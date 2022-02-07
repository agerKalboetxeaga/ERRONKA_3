package Miscellaneous;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.myapplication.R;

public class Music {

    public static void playMusic(Activity act){
        final MediaPlayer music1 = MediaPlayer.create(act, R.raw.music1);
        music1.setLooping(true);
        music1.start();
    }
}
