package com.NewTel.app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Main class for the server of our project.
 * 
 * @author kalboetxeaga.ager
 *
 */
public class ServerMain {

	//Creating sockets
	public static ServerSocket serverSocket=null;
	public static Socket clientSocket=null;
	public static int connexionCount = 0;
	public static ClientManager socket=null;
	
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		try {
			//running Server socket
			serverSocket = new ServerSocket(6689);
			System.out.println("[*] Server running on 6689");
			
			//starting our web service too
			ClientManager.apiServiceStart(); 
			
			//While the program is running
			while(true) {
				
				//Accepting client connection
				clientSocket = new Socket();
				clientSocket = serverSocket.accept();
				
				//Sending client connection to the client manager class
				 socket = new ClientManager(connexionCount, clientSocket); 
				 
				 //Displaying current client`s information
				 System.out.println("\n\t[*] New connection made \n\t\t[IP: " + clientSocket.getInetAddress() + "] [Port: " + clientSocket.getPort() + "]");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 connexionCount++;
				socket.start(); //Start the client manager thread
			
				clientSocket.close(); //Once uploaded data the socket closes
				
			}
			
		}catch(IOException e) {
			System.err.println(e);
			
		}
		
		/**
		 * Theorically on program close will display the total numbers of connections made 
		 */
		Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                 //Your 'pos' shutdown code goes here...
            	System.out.println("[*] In total there were " + connexionCount + " connections with the server" );
            }
        });
	}
	
	 
}
