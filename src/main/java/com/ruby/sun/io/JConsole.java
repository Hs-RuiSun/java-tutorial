package com.ruby.sun.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JConsole {
	public static void main(String[] args) throws Exception {
		File file = new File("/Users/ruisun/Downloads/Berlin.txt");
		File file2 = new File("/Users/ruisun/Downloads/Berlin2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
		String line = null;
		while((line=br.readLine())!=null) {
			if(line.startsWith("0"))
				continue;
			bw.write(line);
		}
		bw.flush();
		bw.close();
	}
}
