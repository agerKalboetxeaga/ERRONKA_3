package Mobs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.MainThread;

import java.util.ArrayList;
import java.util.Random;

public class Enemy1 {

    public Bitmap[] images;
    public Random movement = new Random();
    public static ArrayList<ArrayList<Double>> enemies1 = new ArrayList<>();
    public static int imagesize;

    public Enemy1(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio / 1.4) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio / 1.4) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < enemies1.size(); i++) {
            if (MainThread.times % 4 == 0) {
                if (enemies1.get(i).get(7) < 5) {
                    enemies1.get(i).set(7, enemies1.get(i).get(7) + 1);
                } else {
                    enemies1.get(i).set(7, 0.0);
                }
            }
            canvas.drawBitmap(images[(int) Math.round(enemies1.get(i).get(7))], Math.round(enemies1.get(i).get(0)), Math.round(enemies1.get(i).get(1)), null);
        }

    }

    public void update() {
        for (int i = 0; i < enemies1.size(); i++) {
            if (enemies1.get(i).get(2) == 0 && enemies1.get(i).get(3) == 0) {
                if (MainThread.times % (movement.nextInt(200 - 1) + 1) == 0) {
                    enemies1.get(i).set(2, (double) (movement.nextInt(GameActivity.width -0)));
                    enemies1.get(i).set(3, (double) (movement.nextInt(GameActivity.height -0)));
                }
            } else {
                enemies1.get(i).set(9, Math.sqrt(Math.pow(enemies1.get(i).get(4) - enemies1.get(i).get(2), 2) + Math.pow(enemies1.get(i).get(5) - enemies1.get(i).get(3), 2)));
                if (enemies1.get(i).get(9) > GameActivity.width /5) {
                    if (MainThread.times % 1 == 0) {
                        ArrayList<ArrayList<Double>> points = new ArrayList<>();
                        for (int k = -2; k <= 2; k++) {
                            enemies1.get(i).set(4, enemies1.get(i).get(0));
                            enemies1.get(i).set(4, enemies1.get(i).get(4) + k);
                            for (int w = -2; w <= 2; w++) {
                                enemies1.get(i).set(5, enemies1.get(i).get(1));
                                enemies1.get(i).set(5, enemies1.get(i).get(5) + w);
                                enemies1.get(i).set(9, Math.sqrt(Math.pow(enemies1.get(i).get(4) - enemies1.get(i).get(2), 2) + Math.pow(enemies1.get(i).get(5) - enemies1.get(i).get(3), 2)));
                                ArrayList<Double> point = new ArrayList<>();
                                point.add(enemies1.get(i).get(4));
                                point.add(enemies1.get(i).get(5));
                                point.add(enemies1.get(i).get(9));

                                points.add(point);
                            }
                        }
                        for (int k = 0; k < points.size(); k++) {
                            if (points.get(k).get(2) < enemies1.get(i).get(8)) {
                                enemies1.get(i).set(8, points.get(k).get(2));
                                enemies1.get(i).set(6, (double) k);
                            }
                        }
                        double pos = enemies1.get(i).get(6);
                        enemies1.get(i).set(0, points.get((int) pos).get(0));
                        enemies1.get(i).set(1, points.get((int) pos).get(1));
                    }
                } else {
                    enemies1.get(i).set(2, 0.0);
                    enemies1.get(i).set(3, 0.0);
                    enemies1.get(i).set(9, Double.POSITIVE_INFINITY);
                    enemies1.get(i).set(8, Double.POSITIVE_INFINITY);
                }
            }
        }


    }
}
