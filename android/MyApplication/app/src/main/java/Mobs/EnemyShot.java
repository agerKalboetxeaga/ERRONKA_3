package Mobs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.MainThread;

import java.util.ArrayList;

/**
 * Handles all enemy shots by adding them into the Multi Dimensional array "shots",
 * where every item on the list contains the needed to work
 */

public class EnemyShot {
    private Bitmap[] images;
    public static ArrayList<ArrayList<Double>> shots = new ArrayList<>();
    public static double imagesize;

    public EnemyShot(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio) * images[i].getHeight()), (int) ((GameActivity.height * GameActivity.ratio) * images[i].getWidth()), false);
        }
        imagesize = images[0].getHeight();
    }

    public void draw(Canvas canvas) {
        try {
            for (int i = 0; i <= shots.size(); i++) {
                if (shots.get(i).get(4) > 0) {
                    if (MainThread.times % 1 == 0) {
                        if (shots.get(i).get(5) < 6) {
                            shots.get(i).set(5, shots.get(i).get(5) + 1);
                        }
                    }
                    canvas.drawBitmap(images[(int) Math.round(shots.get(i).get(5))], Math.round(shots.get(i).get(0)), Math.round(shots.get(i).get(1)), null);
                } else {
                    canvas.drawBitmap(images[0], Math.round(shots.get(i).get(0)), Math.round(shots.get(i).get(1)), null);
                }
            }
        } catch (Exception e) {
        }
    }

    public void update() {
            if (Enemy3.enemies3.size() > 0) {
                try{
                for (int i = 0; i < Enemy3.enemies3.size(); i++) {
                    for (int k = 0; k <= shots.size(); k++) {
                        if (shots.get(k).get(3) <= Enemy3.enemies3.get(i).get(5)) {
                            shots.get(k).set(0, shots.get(k).get(0) + shots.get(k).get(6) * Enemy3.enemies3.get(i).get(4));
                            shots.get(k).set(1, shots.get(k).get(1) + shots.get(k).get(7) * Enemy3.enemies3.get(i).get(4));
                            shots.get(k).set(3, shots.get(k).get(3) + 1);
                        }
                        if (shots.get(k).get(3) > Enemy3.enemies3.get(i).get(5) * 0.90) {
                            shots.get(k).set(4, shots.get(k).get(4) + 1);
                        }
                        if (shots.get(k).get(3) > Enemy3.enemies3.get(i).get(5)) {
                            shots.remove(k);
                        }
                    }
                }
            }catch (Exception e){
            }
            } else {
                if (Boss.bosses.size() == 0){
                    shots.clear();
                }
            }

        if (Boss.bosses.size() > 0) {
            try{
            for (int i = 0; i < Boss.bosses.size(); i++) {
                for (int k = 0; k <= shots.size(); k++) {
                    if (shots.get(k).get(3) <= Boss.bosses.get(i).get(11)) {
                        shots.get(k).set(0, shots.get(k).get(0) + shots.get(k).get(6) * Boss.bosses.get(i).get(12));
                        shots.get(k).set(1, shots.get(k).get(1) + shots.get(k).get(7) * Boss.bosses.get(i).get(12));
                        shots.get(k).set(3, shots.get(k).get(3) + 1);
                    }
                    if (shots.get(k).get(3) > Boss.bosses.get(i).get(11) * 0.90) {
                        shots.get(k).set(4, shots.get(k).get(4) + 1);
                    }
                    if (shots.get(k).get(3) > Boss.bosses.get(i).get(11)) {
                        shots.remove(k);
                    }
                }
            }
            }catch (Exception e){
            }
        } else {
            if (Enemy3.enemies3.size() == 0){
                shots.clear();
            }
        }
    }
}
