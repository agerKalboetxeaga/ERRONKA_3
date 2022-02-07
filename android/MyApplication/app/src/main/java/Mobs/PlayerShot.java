package Mobs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Miscellaneous.MainThread;

import java.util.ArrayList;

import Activities.GameActivity;

/**
 * Works the same way as the enemy shots
 */
public class PlayerShot {
    private Bitmap[] images;
    public static ArrayList<ArrayList<Double>> shots = new ArrayList<>();
    public static int imagesize;


    public PlayerShot(Bitmap[] bmp) {
        images = bmp;
        for (int i=0; i < images.length; i++){
            images[i] = Bitmap.createScaledBitmap(images[i], (int)((GameActivity.height * GameActivity.ratio) * images[i].getHeight()) , (int)((GameActivity.height * GameActivity.ratio) * images[i].getWidth()) , false);
        }
        imagesize = images[0].getWidth();
    }
    public void draw(Canvas canvas) {
        try {
            for (int i = 0; i <= shots.size(); i++) {
                if (shots.get(i).get(4) > 0){
                    if (MainThread.times % 1 == 0) {
                        if(shots.get(i).get(5) <6) {
                            shots.get(i).set(5, shots.get(i).get(5) + 1);
                        }
                    }
                    canvas.drawBitmap(images[(int) Math.round(shots.get(i).get(5))], Math.round(shots.get(i).get(0)), Math.round(shots.get(i).get(1)), null);
                }else{
                    canvas.drawBitmap(images[0], Math.round(shots.get(i).get(0)), Math.round(shots.get(i).get(1)), null);
                }
            }
        }catch (Exception e) {
        }
    }

    public void update() {
        try {
            for (int i = 0; i <= shots.size(); i++) {

                if (shots.get(i).get(2) == 4) {
                    if (shots.get(i).get(3) <= Player.range) {
                        shots.get(i).set(1, shots.get(i).get(1) + Player.shotspeed);
                        shots.get(i).set(3, shots.get(i).get(3) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range * 0.90) {
                        shots.get(i).set(4, shots.get(i).get(4) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range){
                        shots.remove(i);
                    }
                }

                if (shots.get(i).get(2) == 3) {
                    if (shots.get(i).get(3) <= Player.range) {
                        shots.get(i).set(0, shots.get(i).get(0) - Player.shotspeed);
                        shots.get(i).set(3, shots.get(i).get(3) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range - 8) {
                        shots.get(i).set(4, shots.get(i).get(4) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range){
                        shots.remove(i);
                    }
                }

                if (shots.get(i).get(2) == 1) {
                    if (shots.get(i).get(3) <= Player.range) {
                        shots.get(i).set(1, shots.get(i).get(1) - Player.shotspeed);
                        shots.get(i).set(3, shots.get(i).get(3) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range - 8) {
                        shots.get(i).set(4, shots.get(i).get(4) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range){
                        shots.remove(i);
                    }
                }

                if (shots.get(i).get(2) == 2) {
                    if (shots.get(i).get(3) <= Player.range) {
                        shots.get(i).set(0, shots.get(i).get(0) + Player.shotspeed);
                        shots.get(i).set(3, shots.get(i).get(3) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range - 8) {
                        shots.get(i).set(4, shots.get(i).get(4) + 1);
                    }
                    if (shots.get(i).get(3) > Player.range){
                        shots.remove(i);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

}
