package com.ruby.sun.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 6666);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sclient = "", sserver = "";
		while(sclient!="bye") {
			sclient = br.readLine();
			dos.writeUTF(sclient);
			dos.flush();
			System.out.println("client: " + sclient);
			sserver = dis.readUTF();
			System.out.println("server: " + sserver);
		}
	}
}
