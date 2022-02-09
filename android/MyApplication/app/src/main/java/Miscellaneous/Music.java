package Miscellaneous;

import android.app.Activity;
import android.media.MediaPlayer;
import com.example.myapplication.R;

import java.util.Random;

public class Music extends Thread{
    private MediaPlayer music;
    private Activity act;
    private Boolean running;
    private Random random = new Random();
    private int selection;

    public Music(Activity act){
        this.act = act;
    }

    public void isRunning(boolean isRunning) {
        running = isRunning;
    }

    public void startLoop(){
        isRunning(true);

        start();
    }

    public void stopLoop(){
        isRunning(false);
        try {
            music.stop();
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        music = MediaPlayer.create(act, R.raw.ambient1);
        music.start();
        while (running) {
            music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    selection = random.nextInt(4 - 0);
                    switch (selection){
                        case 0:
                            music = MediaPlayer.create(act, R.raw.ambient1);
                            music.start();
                            break;
                        case 1:
                            music = MediaPlayer.create(act, R.raw.ambient2);
                            music.start();
                            break;
                        case 2:
                            music = MediaPlayer.create(act, R.raw.ambient3);
                            music.start();
                            break;
                        case 3:
                            music = MediaPlayer.create(act, R.raw.boss1);
                            music.start();
                            break;
                        case 4:
                            music = MediaPlayer.create(act, R.raw.boss2);
                            music.start();
                            break;
                    }
                }
            });
        }
    }
}
