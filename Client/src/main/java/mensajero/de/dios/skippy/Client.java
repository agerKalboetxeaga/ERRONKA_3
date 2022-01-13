package mensajero.de.dios.skippy;

import java.io.*;
import java.net.*;

public class Client {
   public static boolean send (File file){
       boolean sent= false;
        System.out.println("Bezeroa: HASI da.");
        try{
            System.out.println("Bezeroa: 192.168.65.6:6689 zerbitzariarekin konektatu nahian...");
            Socket socketZerbitzareakin = new Socket("192.168.65.6", 6689);  	// Zerbitzariarekin konektatzen saiatuko naiz
            System.out.println("Bezeroa: Konektatu da zerbitzarira. Mezua bidaltzen...");
            
            FileInputStream fis = new FileInputStream(file.getPath());
            byte buffer[] = new byte[(int) file.length()];
            fis.read(buffer, 0 ,buffer.length);
            OutputStream os = socketZerbitzareakin.getOutputStream();		// Zerbitzariari idazteko zabaldutako OutputStream

            os.write(buffer, 0,buffer.length);
           
            System.out.println("Bezeroa: Mezua bidalita. Erantzunaren zai...");

            /*
            InputStream is = socketZerbitzareakin.getInputStream();			// Zerbitzariarekin zabaldutako socket-etik irakurtzeko
            DataInputStream dis = new DataInputStream(is);  				// InputStream-arekin lan egiteko objektu bat
            String  str_mezua = (String) dis.readUTF();  			// Mezu bat espero dugu eta irakurri egingo dugu
            System.out.println("Bezeroa: Jasotako mezua: " + str_mezua);

*/

            // Gure protokoloaren arabera, ez dugu ezer gehiago bidaliko, beraz, fluxuak eta socket-a itxiko ditugu
            //System.out.println("Bezeroa: Mezua bidalita eta erantzuna jasota. Fluxuak eta konexioa isten...");
            fis.close();
            os.close();
            socketZerbitzareakin.close();
            sent= true;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Bezeroa: BUKATU da.");
        return sent;
    }
}
