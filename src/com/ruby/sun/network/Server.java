package com.ruby.sun.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(6666);
			Socket socket = server.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String sclient = "", sserver = "";
			while(sclient!="bye") {
				sclient = dis.readUTF();
				System.out.println("client: " + sclient);
				sserver = br.readLine();
				dos.writeUTF(sserver);
				dos.flush();
				System.out.println("server: " + sserver);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
