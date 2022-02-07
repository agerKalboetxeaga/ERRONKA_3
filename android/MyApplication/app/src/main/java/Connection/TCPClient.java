package Connection;

import android.os.AsyncTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TCPClient extends AsyncTask<File,Void,Void> {

    @Override
    protected Void doInBackground(File... file) {
        try{
            Socket socketZerbitzareakin = new Socket("192.168.65.6", 6969);  	// Zerbitzariarekin konektatzen saiatuko naiz
            System.out.println("Bezeroa: "+socketZerbitzareakin.getRemoteSocketAddress()+":"+socketZerbitzareakin.getPort() + " zerbitzariarekin konektatu nahian...");
            System.out.println("Bezeroa: Konektatu da zerbitzarira. Mezua bidaltzen...");

            FileInputStream fis = new FileInputStream(file[0].getAbsolutePath());
            byte buffer[] = new byte[(int) file[0].length()];
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
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
