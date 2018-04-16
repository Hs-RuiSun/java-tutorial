package com.ruby.sun.security;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Collection;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fr24Connection extends URLConnection {
    /** The Constant LOGGER. */
    private final static Logger LOGGER = LoggerFactory
            .getLogger(Fr24Connection.class);

    public static final int DEFAULT_PORT = 4652;

    public static final String APPLICATION_VND_FR24 = "application/vnd.fr24";

    public static final String DEFAULT_CERTIFICATES = "gd_bundle-g2-g1.crt";

    public static final URL DEFAULT_CERTIFICATES_URL = Fr24Connection.class
            .getResource(DEFAULT_CERTIFICATES);

    private static String cipher = "SSL_RSA_WITH_RC4_128_SHA";

    private static boolean cipherSearch = false;

    private static int counter;

    public Fr24Connection(URL url) {
        super(url);
    }
    
    public static void main(String[] args) throws IOException {
    	Fr24Connection con = new Fr24Connection(DEFAULT_CERTIFICATES_URL);
    	con.connect();
	}

    @Override
    public void connect() throws IOException {
        if (connected) {
            return;
        }
        URL url = new URL("file:///C:/Users/ruby.sun/Downloads/gd_bundle-g2-g1.crt");
        KeyStore keyStore = getKeyStore(url);
        TrustManager[] trustManagers = getTrustManagers(keyStore);
        String host = url.getHost();
        int port = getPort(url);
        SSLSocket socket = createSslSocket(trustManagers, host, port);
        authenticate(socket, url.getUserInfo());
        connected = true;
        this.socket = socket;
    }

    public void disconnect() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }

    private KeyStore getKeyStore(URL url) throws FileNotFoundException,
            IOException {
        try (InputStream fileStream = url.openStream()) {
            CertificateFactory certificateFactory = CertificateFactory
                    .getInstance("X.509");
            Collection<? extends Certificate> certificates = certificateFactory
                    .generateCertificates(fileStream);
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(null, null);
            Certificate certificate = certificates.iterator().next();
            String alias = "trusted";
            keyStore.setCertificateEntry(alias, certificate);
            return keyStore;
        } catch (CertificateException | KeyStoreException
                | NoSuchAlgorithmException e) {
            throw new IOException(e);
        }
    }

    private TrustManager[] getTrustManagers(KeyStore keyStore)
            throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance("PKIX");
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory
                    .getTrustManagers();
            return trustManagers;
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            throw new IOException(e);
        }
    }

    private int getPort(URL u) {
        int port = u.getPort();
        if (port == -1) {
            port = DEFAULT_PORT;
        }
        return port;
    }

    private SSLSocket createSslSocket(TrustManager[] trustManagers,
            String host, int port) throws IOException, UnknownHostException {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLSv1");
            sslContext.init(null, trustManagers, null);
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) socketFactory.createSocket();
            int timeout = (int) MILLISECONDS.convert(30, SECONDS);
            socket.connect(new InetSocketAddress(host, port), timeout);
            socket.setSoTimeout(timeout);
            socket.setEnabledProtocols(new String[] { "TLSv1" });

            // printSupportedCiphers(socket);
            // printEnabledCiphers(socket);

            if (cipherSearch) {
                String[] ciphers = socket.getSupportedCipherSuites();
                if (counter > socket.getSupportedCipherSuites().length - 1) {

                    ciphers = socket.getEnabledCipherSuites();
                    if (counter > socket.getSupportedCipherSuites().length - 1
                            + ciphers.length - 1) {
                        throw new IOException("No cipher suite available");
                    }
                    cipher = ciphers[counter
                            - (socket.getSupportedCipherSuites().length - 1)];
                } else {
                    cipher = ciphers[counter];
                }

                LOGGER.info(cipher);
                counter++;
            }

            socket.setEnabledCipherSuites(new String[] { cipher });

            // LOGGER.error(ciphers[counter]);
            // socket.setEnabledCipherSuites(new String[] { ciphers[counter]
            //
            // });
            // counter++;
            return socket;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new IOException(e);
        }
    }

//    private static void printInfos(String prefix, String[] values) {
//        LOGGER.error(prefix + ":");
//        for (int i = 0; i < values.length; i++)
//            System.out.println("  " + values[i]);
//    }

    private final static int FEED_VERSION = 0x46520001;

    private void authenticate(SSLSocket socket, String password)
            throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(getBytes(FEED_VERSION, 4));
        outputStream.flush();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] challenge = new byte[16];
        dataInputStream.readFully(challenge);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] passwordMd5 = messageDigest.digest(password.getBytes(Charset
                    .forName("US-ASCII")));
            messageDigest.reset();
            messageDigest.update(passwordMd5);
            messageDigest.update(challenge);
            byte[] passwordChallengeMd5 = messageDigest.digest();
            outputStream.write(passwordChallengeMd5);
            outputStream.flush();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        }
    }

    public static byte[] getBytes(int x, int size) {
        ByteBuffer buffer = ByteBuffer.allocate(size);
        buffer.putInt(x);
        return buffer.array();
    }

    private Socket socket;

    @Override
    public String getContentType() {
        return APPLICATION_VND_FR24;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        connect();
        return socket.getInputStream();
    }

    public static void setCipher(String cipher) {
        Fr24Connection.cipher = cipher;
    }

    public static void enableCipherSearch() {
        cipherSearch = true;
    }
}
