package com.NewTel.app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {

	public static ServerSocket serverSocket=null;
	public static Socket clientSocket=null;
	public static int connexionCount = 0;
	public static AppNewTel socket=null;
	
	
	
	public static void main(String[] args) {
		
		
		
		try {
			serverSocket = new ServerSocket(6689);
			System.out.println("[*] Server running on 6689");
			
			while(true) {
				
				
				
				 
				clientSocket = new Socket();
				clientSocket = serverSocket.accept();
				 socket = new AppNewTel(connexionCount, clientSocket);
				 System.out.println("\n\t[*] New connection made \n\t\t[IP: " + clientSocket.getInetAddress() + "] [Port: " + clientSocket.getPort() + "]");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 connexionCount++;
				//final AppNewTel serverThread = new AppNewTel(connexionCount, clientSocket);			
				socket.start();
			
				clientSocket.close();
				
			}
			
		}catch(IOException e) {
			System.err.println(e);
			
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                 //Your 'pos' shutdown code goes here...
            	System.out.println("[*] In total there were " + connexionCount + " connections with the server" );
            }
        });
	}
	
	 
}
