package Mobs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.MainThread;

import java.util.ArrayList;

public class Enemy2 {

    public Bitmap[] images;
    public static ArrayList<ArrayList<Double>> enemies2 = new ArrayList<>();
    public static double imagesize;


    public Enemy2(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio/1.1) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio/1.1) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < enemies2.size(); i++) {
            if (MainThread.times % 4 == 0) {
                if (enemies2.get(i).get(7) < 7) {
                    enemies2.get(i).set(7, enemies2.get(i).get(7) + 1);
                } else {
                    enemies2.get(i).set(7, 0.0);
                }
            }
            canvas.drawBitmap(images[(int) Math.round(enemies2.get(i).get(7))], Math.round(enemies2.get(i).get(0)), Math.round(enemies2.get(i).get(1)), null);
        }
    }

    public void update() {
        for (int i = 0;i<enemies2.size(); i++){
            if (enemies2.get(i).get(2) == 0 && enemies2.get(i).get(3) == 0) {
                enemies2.get(i).set(2, Player.x);
                enemies2.get(i).set(3, Player.y);
            } else {
                enemies2.get(i).set(9,Math.sqrt(Math.pow(enemies2.get(i).get(4) - enemies2.get(i).get(2), 2) + Math.pow(enemies2.get(i).get(5) - enemies2.get(i).get(3), 2)));
                if (enemies2.get(i).get(9) > enemies2.get(i).get(10) * 2) {
                    if (MainThread.times % 1 == 0) {
                        ArrayList<ArrayList<Double>> points = new ArrayList<>();
                        for (int k = (int) -enemies2.get(i).get(10); k <= enemies2.get(i).get(10); k++) {
                            enemies2.get(i).set(4,enemies2.get(i).get(0));
                            enemies2.get(i).set(4,enemies2.get(i).get(4) + k);

                            for (int w = (int) -enemies2.get(i).get(10); w <= enemies2.get(i).get(10); w++) {
                                enemies2.get(i).set(5,enemies2.get(i).get(1));
                                enemies2.get(i).set(5,enemies2.get(i).get(5) + w);
                                enemies2.get(i).set(9,Math.sqrt(Math.pow(enemies2.get(i).get(4) - enemies2.get(i).get(2), 2) + Math.pow(enemies2.get(i).get(5) - enemies2.get(i).get(3), 2)));
                                ArrayList<Double> point = new ArrayList<>();
                                point.add(enemies2.get(i).get(4));
                                point.add(enemies2.get(i).get(5));
                                point.add(enemies2.get(i).get(9));
                                points.add(point);
                            }
                        }
                        for (int k = 0; k < points.size(); k++) {
                            if (points.get(k).get(2) < enemies2.get(i).get(8)) {
                                enemies2.get(i).set(8,points.get(k).get(2));
                                enemies2.get(i).set(6, (double) k);
                            }
                        }
                        double pos = enemies2.get(i).get(6);
                        enemies2.get(i).set(0, points.get((int) pos).get(0));
                        enemies2.get(i).set(1, points.get((int) pos).get(1));
                    }
                } else {
                    enemies2.get(i).set(2, 0.0);
                    enemies2.get(i).set(3, 0.0);
                    enemies2.get(i).set(9, Double.POSITIVE_INFINITY);
                    enemies2.get(i).set(8, Double.POSITIVE_INFINITY);
                }
            }
        }
    }
}
