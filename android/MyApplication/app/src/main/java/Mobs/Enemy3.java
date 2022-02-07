package Mobs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.MainThread;

import java.util.ArrayList;


public class Enemy3 {
    public Bitmap[] images;
    public static ArrayList<ArrayList<Double>> enemies3 = new ArrayList<>();
    public static int imagesize;
    public static double m;

    public Enemy3(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio/1.2) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio/1.2) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < enemies3.size(); i++) {
            if (MainThread.times % 4 == 0) {
                if (enemies3.get(i).get(7) < 6) {
                    enemies3.get(i).set(7, enemies3.get(i).get(7) + 1);
                } else {
                    enemies3.get(i).set(7, 0.0);
                }
            }
            canvas.drawBitmap(images[(int) Math.round(enemies3.get(i).get(7))], Math.round(enemies3.get(i).get(0)), Math.round(enemies3.get(i).get(1)), null);
        }
    }

    public void update() {
        for(int i=0;i<enemies3.size();i++){
            if (MainThread.times % enemies3.get(i).get(6) == 0) {
                ArrayList<Double> shot = new ArrayList<>();
                enemies3.get(i).set(2,(Player.x + Player.imagesize / 4.0) - enemies3.get(i).get(0));
                enemies3.get(i).set(3,(Player.y + Player.imagesize / 4.0) - enemies3.get(i).get(1));
                enemies3.get(i).set(8, Math.sqrt(Math.pow(enemies3.get(i).get(2), 2) + Math.pow(enemies3.get(i).get(3), 2)));
                enemies3.get(i).set(2,enemies3.get(i).get(2) / enemies3.get(i).get(8));
                enemies3.get(i).set(3,enemies3.get(i).get(3) / enemies3.get(i).get(8));
                shot.add(enemies3.get(i).get(0) + imagesize/4);
                shot.add(enemies3.get(i).get(1));
                shot.add(m);
                shot.add(0.0);
                shot.add(0.0);
                shot.add(0.0);
                shot.add(enemies3.get(i).get(2));
                shot.add(enemies3.get(i).get(3));
                EnemyShot.shots.add(shot);
            }
        }
    }
}
