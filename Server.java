package edu.monmouth.socket;

import java.net.*;
import java.io.*;


public class Server {
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Must enter command line argument");
			System.exit(-1);
		}
		
		 
		final int PORT = 3000; //constant for port
		//String IP = args[0]; //constant for ip

		try (//Create a server socket
			ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Waiting on port " + PORT + " for a connection...");
			
			try {
				Socket clientSocket = serverSocket.accept(); //• Accept a request from a client //maybe a try catch
				System.out.println("Accepted return!");
			
				//Using the java.net.InetAddress class...  
				String clientInetAddress = clientSocket.getInetAddress().getHostAddress(); //determine client’s IP
				int remotePort = clientSocket.getPort(); //Determine client’s remote port
				int localPort = clientSocket.getLocalPort(); //Determine client’s local port

				
				//Use the java.io.PrintWriter class to write a message to a client
				OutputStream os = clientSocket.getOutputStream();
				PrintWriter writer = new PrintWriter(os, true);		
				writer.println("Hi this is Marietta, pleased to meet you." 
						+ "I see you are coming from IP address " + clientInetAddress + " and local port # " 
						+ localPort + " and remote port # " + remotePort);
				
				//writer.flush();
				
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cannot create server socket" + e.getMessage());
			System.exit(-1);
			
		}			
	}
}



// in putty enter localhost




















//https://www.youtube.com/watch?app=desktop&v=-xKgxqG411c
/*
				Scanner scan = new Scanner(System.in);
				String DNS = scan.next("Enter an a Domain Name: ");
	
			    InetAddress addr;
			    
			    addr = InetAddress.getByName(DNS);
			    addr.get

*/