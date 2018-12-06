package com.ruby.sun.security;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("127.0.0.1", 5432);
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pwrite = new PrintWriter(client.getOutputStream(), true);

        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(client.getInputStream()));

        System.out.println("Start the chitchat, type and press Enter key");

        String receiveMessage, sendMessage = "";
        while (!sendMessage.equals("exit")) {
            System.out.print("client: ");
            sendMessage = keyRead.readLine();
            pwrite.println(sendMessage);
            pwrite.flush();
            if ((receiveMessage = receiveRead.readLine()) != null) {
                System.out.println("server: " + receiveMessage);
            }
        }
        receiveRead.close();
        keyRead.close();
        pwrite.close();
        client.close();
    }
}
