package com.NewTel.app;

import java.io.*;

import java.util.Date;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

import javax.sound.sampled.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import eus.uni.dam.*;
import com.NewTel.dao.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @Jaggy When the progarm is invoked, it will upload json file data to
 *        postgreSQL database and mongoDB database
 *
 **/

@ComponentScan(basePackages = { "eus.uni.dam" })
@SpringBootApplication
public class AppNewTel extends Thread{
	// Aldagaien deklarazioa

	public static ResPartnerDao resPartnerDao;
	public static PartidakDao partidakDao;
	private static RunHelper runHelper;
	public static ApplicationContext appContext;

	// ArrayListak

	public static List<HrEmployee> employees = new ArrayList<HrEmployee>();
	public static List<PartidakPartida> partidak = new ArrayList<PartidakPartida>();
	public static int count = 3;
	// Booleano batzuk
	// xml-en rutak

	
	private final static String fileInput = "PartidakPlantilla.json";
	private static String logPath = "logs/log.xml";
	private Socket clientSock = null;
	private static Semaphore s = new Semaphore(1); // Semaforoa sarrera baterekin
	private String fileName;
	
	
	public AppNewTel(int threadnum, Socket s) {

		
		// programa nagusia baino garrantzitsuagoa izango da eta hasieratik entzungo da
		
		
		
		
		
		try {
			//ServerSocket serverSock = new ServerSocket(serverPort);
			//System.out.println("[*] Server Running on " + serverPort);

			//while (true) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd-hh_mm_ss");
				int num = (int) (Math.random() * 2500 + 1);
				Date data = new Date();
				String finalDate = dateFormat.format(data);
				fileName = "partidak[" + num + "](" + finalDate + ").json";

				 this.clientSock = s;

				InputStream is = clientSock.getInputStream(); // getting client input stream
				
				FileOutputStream fos = new FileOutputStream(fileName); // creating an output stream with the name of the
				
				 // transferred file
				byte[] buffer = is.readAllBytes();
				
				
				fos.write(buffer, 0, buffer.length);
				fos.close();
				is.close();

				// JPA STARTS
				
				
			//}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}
	public void run() {
		//java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_Postgres.class); // kontextua
		runHelper = appContext.getBean(RunHelper.class);
		resPartnerDao = appContext.getBean(ResPartnerDao.class);
		partidakDao = appContext.getBean(PartidakDao.class);

		try (FileReader file = new FileReader(fileName)) {

			readJson(file);

			Runnable mongolize = new Runnable() {
				@Override
				public void run() {

					mongolize(fileName);
				}
			};
			Runnable updatedb = new Runnable() {
				@Override
				public void run() {
					updateDB();
				}
			};
			Thread mongo = new Thread(mongolize);
			Thread postgres = new Thread(updatedb);
			mongo.start();

			postgres.start();
			postgres.join();
			
			//openSound(1); // 2 gemido, 1 success
			//System.exit(1);
		} catch (Exception e) {

			System.err.println("Error opening file...\n\n");
			e.printStackTrace();
		}
	}

	/**
	 * This method will execute a prgogram to upload json data to mongo database
	 * 
	 * @param fileName
	 */
	private static void mongolize(String fileName) {
		Thread mongolizator = new Thread(new Runnable() {

			@Override
			public synchronized void run() { // creo que si no se sincronizan se peta en el logeo del postgres?
				try {
					String command = "bash ./mongolize.sh \"" + fileName + "\" 2>&1"; // no es este pero bueno... [2>&1 es
																					// para ocultar el output de consola
																					// (bash)]

					Process mongolize = Runtime.getRuntime().exec(command); // y el programita hace su magia...

				} catch (IOException e) {
					System.out.println("\n\nError trying to mongolize file....");
					e.printStackTrace();
				//	System.exit(1);
				}
			}
		});
		mongolizator.start();
	}
	public static boolean apiServiceStart() {
		Boolean succes = false;
		Thread apiService = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String command = "java -jar rest_service.jar";
					
					Process server = Runtime.getRuntime().exec(command);
				}catch(IOException e) {
					System.out.println("\n\n[*] There was an Error setting up the rest service");
				}
				
			}
			
		});
		apiService.start();
		succes = true;
		return succes;
	}

	/**
	 * Metodo honek aukeratutako aukerak PostgreSQLra igotzen dira.
	 *
	 * @return Atazak arrakasta izan badu:
	 */
	public static boolean updateDB() {
		boolean success = true;
		/**
		 * Postgresentzat erabiltzen dugun ApplicationContexta ixten dugu errekurtsoak
		 * berreskuratzeko eta beste aplication context bat zabaltzen dugu MS sql
		 * serverrera konekxioa egoteko
		 */

		// update bakoitzean semaforoaren bidez updateak ordenatuta joango dira
		try {

			try {
				s.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (partidak != null) {
				for (PartidakPartida p : partidak)
					partidakDao.update(p);

			}
			s.release();

		} catch (Exception ex) {
			ex.printStackTrace();
			success = false;
		}

		((AnnotationConfigApplicationContext) appContext).close(); // MS sql serverreako erabili dugun aplikazioaren
		// kontextua ixten dugu
		return success;
	}

	/**
	 * Metodo honek soinu bat abiarazten du hari moduan
	 */
	public static void openSound(int soundType) {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File sound = null;
					if (soundType == 1) {
						sound = new File("sounds/Download_succeed.wav");
					} else if (soundType == 2) { // fitxategia asignatu
						sound = new File("sounds/Gemidos.wav");

					}
					AudioInputStream stream; // Audio motako stream bat sortu
					AudioFormat format; // Formatua ezartzeko (wav)
					DataLine.Info info; // Clip klaseak behar duen soinuaren konfigurazio informazioa
					Clip clip; // wav fitxategia kudeatzeko klasea

					stream = AudioSystem.getAudioInputStream(sound);
					format = stream.getFormat();
					info = new DataLine.Info(Clip.class, format);
					clip = (Clip) AudioSystem.getLine(info);
					clip.open(stream);
					//clip.start();
					System.out.println("PROGRAM FINISHED");
					Thread.sleep(200);

				} catch (Exception e) {
					// whatevers
					e.printStackTrace();
				}
			}
		});

		try {
			th.start(); // soinuaren haria hasi
			Thread.sleep(4000); // programa nagusia gelditu soinua erreproduzitzeko 3000 para el otro sonido
			//System.exit(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo honek log fitxategi bat sortzen du xml formatuan
	 */
	public static void logMaker() {

		File log = new File(logPath); // Fitxategi objetu bat fitxategia egongo den lekuan
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = null;

			documentBuilder = documentFactory.newDocumentBuilder();

			if (!log.exists()) { // Log -a lehenago sortuta ez badago

				Document document = (Document) documentBuilder.newDocument(); // Dokumentu berri bat sortzen da lehenago
																				// ezarritako rutan
				Element root = document.createElement("LOG");
				document.appendChild(root);
				Element logtxt = document.createElement("Exportazioa");
				LocalDateTime date = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formattedDate = date.format(formatter);
				String txt = formattedDate + ", ";
				if (employees != null) {
					txt = txt + employees.size() + " employees were exported ";
				}

				if (partidak != null) {
					txt = txt + partidak.size() + " partidak were played";
				}
				if (employees == null && partidak == null) {
					txt = txt + "I dont know you haven´t exported anything";
				}

				logtxt.setTextContent(txt);
				root.appendChild(logtxt);

				TransformerFactory transformers = TransformerFactory.newInstance(); // Lehenago bezela xml fitxategia
																					// sortzen da
				Transformer bambelbi = transformers.newTransformer();
				DOMSource doomSlayer = new DOMSource(document);
				StreamResult streamResult = new StreamResult(log);
				bambelbi.transform(doomSlayer, streamResult);

			} else {
				/**
				 * Fitxategia sortuta badago
				 */
				Document document = documentBuilder.parse(log); // ihadanik sortuta dagoen xml fitxategia erabiltzen da
				Element root = document.getDocumentElement();
				Element rootElement = document.getDocumentElement();

				Element logtxt = document.createElement("Exportazioa");
				LocalDateTime date = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formattedDate = date.format(formatter);
				String txt = formattedDate + ", ";
				if (employees != null) {
					txt = txt + employees.size() + " employees were exported ";
				}

				if (partidak != null) {
					txt = txt + partidak.size() + " partidak were played";
				}
				if (employees == null && partidak == null) {
					txt = txt + "I dont know you haven´t exported anything";
				}
				logtxt.setTextContent(txt);
				rootElement.appendChild(logtxt);

				root.appendChild(logtxt);

				DOMSource source = new DOMSource(document);

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				StreamResult result = new StreamResult(log);
				transformer.transform(source, result); // Lehenago zegoen fitxategiari log -aren informazioa gehitzen
														// dio

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // working...

	/**
	 * Programa exekutatzerakoan erabiltzaileak sartutako inputa kudeatzen duen
	 * metodoa
	 *
	 * @param args user provided arguments
	 */

	public static void readJson(FileReader jFile) {
		// Json reader code:
		JSONParser jsonParser = new JSONParser();

		try {
			Object obj = jsonParser.parse(jFile);

			JSONObject fitxategia = (JSONObject) obj;
			JSONObject langilea = (JSONObject) fitxategia.get("employee");
			// ObjectMapper objectMapper = new ObjectMapper();

			/*
			 * Esto convierte directamente los objetos json en objetos java
			 */
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			try {
				date = dateFormat.parse((String) fitxategia.get("date"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long finDate = date.getTime();
			HrEmployee employee = new HrEmployee(Integer.parseInt((String) langilea.get("id")),
					(String) langilea.get("name"), (String) langilea.get("jobTitle"), (String) langilea.get("workPhone"),
					(String) langilea.get("workEmail"));
			
			
			employees.add(employee);
			partidak.add(new PartidakPartida(count, Integer.parseInt((String) fitxategia.get("puntuazioa")),
					Integer.parseInt((String) fitxategia.get("kills")), (String) fitxategia.get("time"),
					new Timestamp(finDate), employee));
			// employees.add(objectMapper.readValue((DataInput) langilea,
			// ResPartner.class)); //hope it works :`) jej
			// partidak.add(objectMapper.readValue((DataInput) fitxategia,
			// PartidakPartida.class));
			count++;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

}
