package com.ruby.sun.unitest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.management.DescriptorKey;
import javax.net.ssl.SSLServerSocket;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.fail;

import org.mockito.MockitoAnnotations;

public class SSLServerConnectionTest {
	/*@Mock
	SSLServerSocket serverSocket;
	@Mock
	Socket socket;
	@InjectMocks
	SSLServerConnection connection;*/

    //@Before
    public void setup() {
        //MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testSocket() {
        InputStream in = mock(InputStream.class);
        ServerSocket mockServerSocket = mock(ServerSocket.class);
        // Set it first
        Socket mockTestClientSocket = mock(Socket.class);

        try {
            // Then mock it
            when(mockServerSocket.accept()).thenReturn(mockTestClientSocket);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Ignore
    public void testAccept() throws IOException {
        Socket socket = mock(Socket.class);
        SSLServerSocket serverSocket = mock(SSLServerSocket.class);
        Mockito.when(serverSocket.accept()).thenReturn(socket);

        //SSLServerConnection connection = Mockito.mock(SSLServerConnection.class);
        //Mockito.doThrow(new IOException()).when(connection).accept();
    }
}
