package com.NewTel.app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket clientSocket;
		int connexionCount = 0;
		
		
		try {
			serverSocket = new ServerSocket(6689);
			System.out.println("[*] Server running on 6689");
			
			while(true) {
				clientSocket = new Socket();
				clientSocket = serverSocket.accept();
				final AppNewTel serverThread = new AppNewTel(connexionCount, clientSocket);			
				System.out.println("\n[*] New connection made \n\t[IP: " + clientSocket.getInetAddress() + "] [Port: " + clientSocket.getLocalPort() + "]");

				System.setOut(new PrintStream(new OutputStream() { //agurr output
					  public void write(int b) {
					    // NO-OP
						 serverThread.start();
					  }
					}));
				
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
