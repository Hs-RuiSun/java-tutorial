package com.ruby.sun.security;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3000);
		System.out.println("Server  ready for chatting");
		Socket sock = server.accept();
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);

		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));

		String receiveMessage, sendMessage;
		while (true) {
			if ((receiveMessage = receiveRead.readLine()) != null) {
				if(receiveMessage.equals("exit"))
					System.out.println("client has exit");
				else
					System.out.println("client: " + receiveMessage);
			}
			System.out.print("server: ");
			sendMessage = keyRead.readLine();
			pwrite.println(sendMessage);
			pwrite.flush();
		}
	}
}
