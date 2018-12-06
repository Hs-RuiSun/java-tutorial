package com.ruby.sun.multithread.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadpoolServer implements Runnable {
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);
    private Socket clientSocket = null;
    private ServerSocket serverSocket = null;
    private boolean isStopped = false;
    private int port = 9000;

    public ThreadpoolServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
                serverSocket = openServerSocket();
                clientSocket = serverSocket.accept();
                threadPool.execute(new SocketRunnable(clientSocket, "multithread socket"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.threadPool.shutdown();
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    private void close() throws IOException {
        if (serverSocket != null) {
            serverSocket.close();
        }
        isStopped = true;
    }

    private ServerSocket openServerSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        return serverSocket;
    }
}
