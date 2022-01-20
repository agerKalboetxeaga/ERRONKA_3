package mongolizador;

import java.io.IOException;

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

