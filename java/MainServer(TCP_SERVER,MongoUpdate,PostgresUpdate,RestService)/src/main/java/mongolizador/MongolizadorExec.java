package mongolizador;

import java.io.IOException;

/**
 * This class will be used to run the mongolizador script (Deprecated)
 * 
 * @author kalboetxeaga.ager
 *
 */
public class MongolizadorExec implements Runnable {

    @Override
    public void run() {
        try {
            Process mongolize = Runtime.getRuntime().exec("bash mongolize.sh ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

