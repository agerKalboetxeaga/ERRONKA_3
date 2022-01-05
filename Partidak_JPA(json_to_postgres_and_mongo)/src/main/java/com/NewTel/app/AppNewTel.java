package com.NewTel.app;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
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
 * @Jaggy
 * When the progarm is invoked, it will upload json file data
 * to postgreSQL database and mongoDB database
 *
 * **/



@ComponentScan(basePackages = {"eus.uni.dam"})
@SpringBootApplication
public class AppNewTel {
    //Aldagaien deklarazioa


    public static ResPartnerDao resPartnerDao;
    public static PartidakDao partidakDao;
    private static RunHelper runHelper;
    public static ApplicationContext appContext;

    //ArrayListak

    public static List<ResPartner> employees;
    public static List<PartidakPartida> partidak;

    //Booleano batzuk
    //xml-en  rutak

    public static String logPath = "logs/log.xml";

    public static Semaphore s = new Semaphore(1); //Semaforoa sarrera baterekin

    public static void main(String[] args) {

        //Abestiaren hariari prioritate handiena emango diogu, horrela
        // programa nagusia baino garrantzitsuagoa izango da eta hasieratik entzungo da


        appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_Postgres.class);  //kontextua eta postgres daoak abiarazi
        //
        runHelper = appContext.getBean(RunHelper.class);
        resPartnerDao = appContext.getBean(ResPartnerDao.class);
        partidakDao = appContext.getBean(PartidakDao.class);

        runMain(args);

    }

    /**
     * This method will execute a prgogram to upload json data to mongo database
     * @param fileName
     */
    private static void mongolize(String fileName) {
        Thread mongolizator = new Thread(new Runnable() {

            @Override
            public synchronized void run() { //creo que si no se sincronizan se peta en el logeo del postgres?
                try {
                    String command = "bash mongolize.sh " + fileName + " 2>&1"; //no es este pero bueno...  [2>&1 es para ocultar el output de consola (bash)]

                    Process mongolize = Runtime.getRuntime().exec(command); //y el programita hace su magia...

                } catch (IOException e) {
                    System.out.println("\n\nError trying to mongolize file....");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        });
        mongolizator.start();
    }

    /***
     * Menua lehen aldiz bistaratzen duzunean erabiltzen den menua //deprecated
     */
    public static void menuOsoaBistaratu() {
        int election;
        List<String> aukerak = new ArrayList<String>();     //erabiltzaileak aukeratuko dituen objetuak esportatzeko
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        // Menua bistaratu

        System.out.println(
                "\n\n\n\n\n\n\t\t XML SORTZAILEA:\n\tAukeratu zer exportatu nahi duzun(1,...):\n1-Bezeroak\n2-Produktuak\n3-Salmentak\n\n4-Eginda");
        while (!exit) {
            election = sc.nextInt();                    //Erabiltzaileraren inputa

            switch (election) {
                case 1:
                    System.out.println("Bezeroak aukeratu duzu.");
                    aukerak.add("bezeroak");
                    break;
                case 2:
                    System.out.println("Produktuak aukeratu dituzu");
                    aukerak.add("produktuak");
                    break;
                case 3:
                    System.out.println("Salmentak aukeratu dituzu");
                    aukerak.add("salmentak");
                    break;
                case 4:
                    System.out.println("Erosketak aukeratu dituzu");
                    aukerak.add("erosketak");
                case 5:
                    Thread th = new Thread("datuak gordetzen...");
//
                    try {
                        th.sleep(2000);

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    exit = true;                                        //Amaiera

            }

        }


    } //obsolete


    /**
     * Metodo honek aukeratutako aukerak PostgreSQLra igotzen dira.
     *
     * @return Atazak arrakasta izan badu:
     */
    public static boolean updateDB() {
        boolean success = true;
        /**
         * Postgresentzat erabiltzen dugun ApplicationContexta ixten dugu errekurtsoak berreskuratzeko
         * eta beste aplication context bat zabaltzen dugu MS sql serverrera konekxioa egoteko
         */

        //update bakoitzean semaforoaren bidez updateak ordenatuta joango dira
        try {
            /*
            Thread partnerUpdate = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (employees != null) {                //Exportatzeko zer dagoen begiratzen du
                        for (ResPartner rp : employees)

                            resPartnerDao.update(rp);
                    }
                    s.release();
                }
            });
*/

            Thread partidakUpdate = new Thread(new Runnable() {
                @Override
                public void run() {
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
                }
            });

            //partnerUpdate.start();
            //partnerUpdate.join();                                   //Haria hasi eta itxaron amaitu harte

            partidakUpdate.start();
            partidakUpdate.join();
            //programa un proceso pa ke ejecute el "mongolizador"

        } catch (Exception ex) {
            ex.printStackTrace();
            success = false;
        }

        ((AnnotationConfigApplicationContext) appContext).close(); //MS sql serverreako erabili dugun aplikazioaren
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
                    } else if (soundType == 2) {                                       //fitxategia asignatu
                        sound = new File("sounds/Gemidos.wav");

                    }
                    AudioInputStream stream;                                        //Audio motako stream bat sortu
                    AudioFormat format;                                             //Formatua ezartzeko (wav)
                    DataLine.Info info;                                             //Clip klaseak behar duen soinuaren konfigurazio informazioa
                    Clip clip;                                                      // wav fitxategia kudeatzeko klasea

                    stream = AudioSystem.getAudioInputStream(sound);
                    format = stream.getFormat();
                    info = new DataLine.Info(Clip.class, format);
                    clip = (Clip) AudioSystem.getLine(info);
                    clip.open(stream);
                    clip.start();
                    System.out.println("PROGRAM FINISHED");
                    Thread.sleep(200);


                } catch (Exception e) {
                    //whatevers
                    e.printStackTrace();
                }
            }
        });

        try {
            th.start();                               //soinuaren haria hasi
            Thread.sleep(4000);                 //programa nagusia gelditu soinua erreproduzitzeko 3000 para el otro sonido
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo honek log fitxategi bat sortzen du xml formatuan
     */
    public static void logMaker() {

        File log = new File(logPath);   //Fitxategi objetu bat fitxategia egongo den lekuan
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = null;

            documentBuilder = documentFactory.newDocumentBuilder();

            if (!log.exists()) { //Log -a lehenago sortuta ez badago

                Document document = (Document) documentBuilder.newDocument(); //Dokumentu berri bat sortzen da lehenago ezarritako rutan
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

                TransformerFactory transformers = TransformerFactory.newInstance(); //Lehenago bezela xml fitxategia sortzen da
                Transformer bambelbi = transformers.newTransformer();
                DOMSource doomSlayer = new DOMSource(document);
                StreamResult streamResult = new StreamResult(log);
                bambelbi.transform(doomSlayer, streamResult);

            } else {
                /**
                 * Fitxategia sortuta badago
                 */
                Document document = documentBuilder.parse(log); //ihadanik sortuta dagoen xml fitxategia erabiltzen da
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
                transformer.transform(source, result);  //Lehenago zegoen fitxategiari log -aren informazioa gehitzen dio

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    } //working...

    /**
     * Programa exekutatzerakoan erabiltzaileak sartutako inputa kudeatzen duen metodoa
     *
     * @param args user provided arguments
     */
    private static void runMain(String[] args) {
        List<String> argumentos = Arrays.asList(args);
        List<String> aukerak = new ArrayList<>();

        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "-h", "-help" -> {
                    System.out.println(runHelper.getHelper());
                    System.exit(0);
                }
                case "-sapo" -> {
                    System.out.println("\n\n\n\n\n\n\n\nJaja pringauu");
                    openSound(2);
                    System.exit(0);
                }
                default -> {
                    System.out.println("Syntax error");
                    System.out.println(runHelper.getHelper());
                    System.exit(-1);
                }
            }


            //openSound(1);
        } else if (!argumentos.contains("sapo") && args.length > 3) {

            System.out.println("Syntax error");
            System.out.println(runHelper.getHelper());
            System.exit(-1);

        }/*else if(args.length == 0){
            File file = new File(path);
            if(file.exists()){
                Scanner sc = new Scanner(System.in);
                System.out.println("Konfigurazioa gordeta daukagu erabiltzea nahi duzu?\n\t\t(b/e)");
                String election = sc.next();
                if(election.equals("b")){
                    try {
                        if (bExported) {                            //Ea zer objetu exportatu diren begiratzen du.
                            employees = new ArrayList<ResPartner>();
                            employees = resPartnerDao.getAll();
                        }
                        if (pExported) {
                            products = new ArrayList<ProductProduct>();
                            products = productDao.getAll();
                        }
                        if (sExported) {
                            sales = new ArrayList<SaleOrder>();
                            sales = salesDao.getAll();
                            salesLines = new ArrayList<SaleOrderLine>();
                            salesLines = saoLineDao.getAll();
                        }
                        if (puExported){
                            purchases = new ArrayList<PurchaseOrder>();
                            purchases = purchaseOrderDao.getAll();
                            purchasesLines = new ArrayList<PurchaseOrderLine>();
                            purchasesLines = purchaseOrderLineDao.getAll();
                        }
                        updateDB();                             //Aurreko menuan bezala
                        logMaker();
                        openSound(1);
                    } catch (Exception ex) {
                        System.out.println("Errorea datubase prozesuan (menuaBistaratu)");
                        ex.printStackTrace();
                    }
                }else{
                    System.out.println("Ongi da");
                    file.delete();
                    System.exit(-1);
                }

            }else{
                System.out.println("Errorea, ez duzu konfigurazio fitxategirik");
            }
        }*/ else if (args.length == 2) { //for only one file

            try (FileReader jsonFile = new FileReader(args[1])) {

                readJson(jsonFile);

            } catch (Exception e) {

                System.err.println("Error opening file...\n\n");
                e.printStackTrace();
            }

        } else if (args.length > 2) {//more than one file

            FileReader jsonFile;

            for (String fileName : args) {
                if (fileName.equals("-f") || fileName.equals("--file")) { //primer arg
                } else {
                    if (fileName.endsWith(".json")) { //json file checker
                        try {

                            jsonFile = new FileReader(fileName);
                            readJson(jsonFile);

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

                            mongolize.run();
                            updatedb.run();


                        } catch (FileNotFoundException e) {
                            e.printStackTrace();

                        }
                    } else {

                        System.out.println("\n\n[!] Syntax Error!\n\t Please enter valid json files");
                        System.exit(1);
                    }
                }
            }
        }
        /*else{
            List<String[]> arguments = new ArrayList<String[]>();

            for(String arg: args){
                switch (arg.toLowerCase()){
                    case "-h" :
                    case "-help":
                        System.out.println(runHelper.getHelper());

                        System.exit(-1);
                        break;

                    case "-sapo":
                        System.out.println("\n\n\n\n\n\n\n\nJaja pringauu");
                        openSound(2);
                        System.exit(-1);
                        break;
                    default:
                        System.out.println("Syntax error");
                        System.out.println(runHelper.getHelper());
                        System.exit(-1);
                        break;

                }
            }
            updateDB();
            logMaker();
            openSound(1);
        }*/

    }

    public static void readJson(FileReader jFile) {
        //Json reader code:
        JSONParser jsonParser = new JSONParser();

        try {
            Object obj = jsonParser.parse(jFile);

            JSONObject fitxategia = (JSONObject) obj;
            JSONObject langilea = (JSONObject) fitxategia.get("Langilea");
            ObjectMapper objectMapper = new ObjectMapper();


            /*
            * Esto convierte directamente los objetos json en objetos java
            *  */
            employees.add(objectMapper.readValue((DataInput) langilea, ResPartner.class)); //hope it works :`) jej
            partidak.add(objectMapper.readValue((DataInput) fitxategia, PartidakPartida.class));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }

}
