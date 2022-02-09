package Activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.example.myapplication.R;

import Miscellaneous.GameView;

import Connection.JSONcreator;
import Connection.TCPClient;
import Miscellaneous.Music;
import Sprites.Paper;

public class GameActivity extends Activity {
        public static int width,height;
        public static double ratio = 0.00231481481;
        private GameView gameView;
        private Music music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        music = new Music(this);
        music.startLoop();
        gameView =new GameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (Paper.paper == 1) {
            JSONcreator.createJSON();
            new TCPClient().execute(JSONcreator.jsonfile);
            Paper.paper=0;
        }
        music.stopLoop();
        gameView.pause();
        gameView.timerpause();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (Paper.paper == 1){
            JSONcreator.createJSON();
            new TCPClient().execute(JSONcreator.jsonfile);
            Paper.paper=0;
        }
        music.stopLoop();
        gameView.pause();
        gameView.timerpause();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}