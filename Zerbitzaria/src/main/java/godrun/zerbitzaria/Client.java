package godrun.zerbitzaria;

import java.io.*;
import java.net.*;

public class Client {
    private static String serverIP= "192.168.65.6";
    private static int serverPort= 6689;
   public static boolean send (File file){
       boolean sent= false;
        System.out.println("Bezeroa: HASI da.");
        try{
            System.out.println("Bezeroa: "+ serverIP+":"+serverPort + " zerbitzariarekin konektatu nahian...");
            Socket socketZerbitzareakin = new Socket(serverIP, serverPort);  	// Zerbitzariarekin konektatzen saiatuko naiz
            System.out.println("Bezeroa: Konektatu da zerbitzarira. Mezua bidaltzen...");

            byte[] byteArray = new byte[1024];
            InputStream is = socketZerbitzareakin.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int bytesReader = is.read(byteArray, 0, byteArray.length);

            bos.write(byteArray, 0, bytesReader);
            bos.close();
            socketZerbitzareakin.close();
            is.close();

            System.out.println("Bezeroa: Fitxategia bidalita...");
            // Gure protokoloaren arabera, ez dugu ezer gehiago bidaliko, beraz, fluxuak eta socket-a itxiko ditugu


            sent= true;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Bezeroa: BUKATU da.");
        return sent;
    }
}