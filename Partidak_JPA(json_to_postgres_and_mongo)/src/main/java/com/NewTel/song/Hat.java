package com.NewTel.song;

import javax.sound.sampled.*;
import java.io.File;

public class Hat extends Thread {
    @Override
    public synchronized void run() {
        super.run();
        try {

            File sound = new File("sounds/GM1CH_02.wav");//"sounds/Download_succeed.wav"
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(sound);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            int top = 1;

                clip.start();
                clip.loop(3);

        }
        catch (Exception e) {
            //whatevers
            e.printStackTrace();
        }

    }
}
