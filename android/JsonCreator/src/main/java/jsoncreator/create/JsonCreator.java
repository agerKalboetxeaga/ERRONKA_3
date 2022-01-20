package jsoncreator.create;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonCreator {
	public static void main(String[] args) {
		jsonCreator();

	}

	public static void jsonCreator() {
		String result;

		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject langilea_Item = new JSONObject();
		//los primeros campos son las llaves que tendra en el json y el segundo parametro su valor
		langilea_Item.put("id", id_employee.toString());
		langilea_Item.put("name", name_employee.toString());
		langilea_Item.put("jobTitle", jobTitle_employee.toString());
		langilea_Item.put("workPhone", work_phone_employee.toString());
		langilea_Item.put("workEmail", work_email_employee.toString());
		

		json.put("employee", array);

		json.put("date", date.toString());
		json.put("time", timeOfTheRun.toString());
		json.put("kills", killsDone.toString());
		json.put("puntuazioa", puntuacion.toString());

		// Printing the contents of the JSONObject to a JSON file
		PrintWriter printWriter = new PrintWriter("OutputInJSONFormat.json");
		printWriter.write(json.toString());
		printWriter.flush();
		printWriter.close();

		System.out.println("Json File created successfully");
		

		// TASK CADA 10 MINS
		sendFile();

		// String jsonString = "{'puntuazioa':+}"
	}

	public static void sendFile() {
		Thread haria = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				Socket s;
				try {
					s = new Socket("127.0.0.1", 6666);
					File file = new File("OutputInJSONFormat.json");
					FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis);
					// Get socket's output stream
					OutputStream os = s.getOutputStream();
					// Read File Contents into contents array
					byte[] contents;
					long fileLength = file.length();
					long current = 0;
					long start = System.nanoTime();
					while (current != fileLength) {
						int size = 10000;
						if (fileLength - current >= size)
							current += size;
						else {
							size = (int) (fileLength - current);
							current = fileLength;
						}
						contents = new byte[size];
						bis.read(contents, 0, size);
						os.write(contents);
						System.out.print("Sending file ... " + (current * 100) / fileLength + "% complete!");
					}
					os.flush();
					// File transfer done. Close the socket connection!
					s.close();
					s.close();
					System.out.println("File sent succesfully!");

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		});
		while(true) {
			
			try {
				haria.start();
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
