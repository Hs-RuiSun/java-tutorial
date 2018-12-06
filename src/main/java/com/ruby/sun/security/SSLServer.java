package com.ruby.sun.security;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SSLServer {
    public static void main(String[] args) throws Exception {
        String path = "/C:/Users/ruby.sun/Downloads/keystore.jks";
        String password = "password";
		/*System.setProperty("javax.net.ssl.keyStore", path);
	    System.setProperty("javax.net.ssl.keyStorePassword", password);*/

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(path), password.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("PKIX");
        kmf.init(ks, password.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("PKIX");
        tmf.init(ks);

        SSLContext sc = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = tmf.getTrustManagers();
        sc.init(kmf.getKeyManagers(), trustManagers, null);

        SSLServerSocketFactory ssf = (SSLServerSocketFactory) sc.getServerSocketFactory().getDefault();
        ServerSocket ss = ssf.createServerSocket(5432);

        while (true) {
            Socket s = ss.accept();
            SSLSession session = ((SSLSocket) s).getSession();
            Certificate[] cchain2 = session.getLocalCertificates();
            for (int i = 0; i < cchain2.length; i++) {
                System.out.println(((X509Certificate) cchain2[i]).getSubjectDN());
            }
            System.out.println("Peer host is " + session.getPeerHost());
            System.out.println("Cipher is " + session.getCipherSuite());
            System.out.println("Protocol is " + session.getProtocol());
            System.out.println("ID is " + new BigInteger(session.getId()));
            System.out.println("Session created in " + session.getCreationTime());
            System.out.println("Session accessed in " + session.getLastAccessedTime());

            PrintStream out = new PrintStream(s.getOutputStream());
            out.println("Hi");
            out.close();
            s.close();
        }
    }
}
