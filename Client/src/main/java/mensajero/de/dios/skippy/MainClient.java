package mensajero.de.dios.skippy;

import java.io.File;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread sender = new Thread(new Runnable() {

			public void run() {
				while(true){
				while(!Client.send(new File("PartidakPlantilla.json"))){
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
					try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
				}
				
			}

                
            
        });

        sender.start();
	}

}
