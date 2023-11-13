package edu.monmouth.socket;

import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		
		
	if(args.length != 1) {
		System.out.println("Must supply server in command line");
		System.exit(-1);
	}
		final int PORT = 3000; //constant for port
		final String IP = args[0]; //constant for local host IP
		
		try (//comandline argument
			Socket socket = new Socket(IP, PORT)) {//host name, port #
			System.out.println("Socket established!");
			
			//read in message from server
			InputStream input = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(input));
			
			String message = bf.readLine();
			while(message != null) {
				System.out.println(message);
			}
			//socket.close();	
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cannot attach to server " + e.getMessage());
			System.exit(-1);
		} 
	}
}
