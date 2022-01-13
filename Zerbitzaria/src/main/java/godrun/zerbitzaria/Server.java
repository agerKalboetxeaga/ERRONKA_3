package godrun.zerbitzaria;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private final static int serverPort = 6689;
	private final static String fileInput = "file.json";
	
	public static void main(String args[]) {
		try {
			ServerSocket servsock= new ServerSocket(serverPort);
			System.out.println("[*] Server Running on " + serverPort);
			int num = (int)(Math.random()*2500+1);
			File jsonFile = new File(fileInput);
			while(true) {
				Socket clientSocket= servsock.accept();
				InputStream in = clientSocket.getInputStream();
				
				OutputStream output = new FileOutputStream("partidak["+num+"].json");
				BufferedOutputStream fos = new BufferedOutputStream(output);
				byte[] buffer = new byte[1024];
				int bytesRead = in.read(buffer, 0, buffer.length);
				
				while ((bytesRead = in.read(buffer)) != -1) {
					output.write(buffer, 0, bytesRead);
				}
				output.close();
				clientSocket.close();
				
				//JPA STARTS
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
