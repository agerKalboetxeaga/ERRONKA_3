package Mobs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.MainThread;

import java.util.ArrayList;
import java.util.Random;

/**
 * Handles the movement and AI of the boss,
 * this works by using the pseudo random number generator to make the boss choose
 * between two different attacks and between different time for each one.
 * This is how every AI works in the game.
 */
public class Boss {
    public Bitmap[] images;
    public Random movement = new Random();
    public static ArrayList<ArrayList<Double>> bosses = new ArrayList<>();
    public static int imagesize;
    public static double deltax, deltay, dis,xnew,ynew,angle;

    public Boss(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio / 0.8) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio / 0.8) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < bosses.size(); i++) {
            if (MainThread.times % 6 == 0) {
                if (bosses.get(i).get(6) < 5) {
                    bosses.get(i).set(6, bosses.get(i).get(6) + 1);
                } else {
                    bosses.get(i).set(6, 0.0);
                }
            }
            canvas.drawBitmap(images[(int) Math.round(bosses.get(i).get(6))], Math.round(bosses.get(i).get(0)), Math.round(bosses.get(i).get(1)), null);
        }
    }

    public void update() {
        for (int i = 0; i < bosses.size(); i++) {
            if (bosses.get(i).get(3) == 0) {
                bosses.get(i).set(2, bosses.get(i).get(2) + 1);
                if (bosses.get(i).get(2) >= bosses.get(i).get(4)) {
                    bosses.get(i).set(4, (double) movement.nextInt(500 - 200) + 200);
                    bosses.get(i).set(5, (double) movement.nextInt(3 - 1) + 1);
                    bosses.get(i).set(2, 0.0);
                    bosses.get(i).set(3, 1.0);
                }
            }

            deltax = (Player.x + Player.imagesize / 2) - (bosses.get(i).get(0) + imagesize / 2);
            deltay = (Player.y + Player.imagesize / 2) - (bosses.get(i).get(1) + imagesize / 2);
            dis = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
            deltax /= dis;
            deltay /= dis;


            if (bosses.get(i).get(5) == 1.0) {
                bosses.get(i).set(0, bosses.get(i).get(0) + deltax * bosses.get(i).get(7));
                bosses.get(i).set(1, bosses.get(i).get(1) + deltay * bosses.get(i).get(7));
                bosses.get(i).set(3, 0.0);
            }
            if (bosses.get(i).get(5) == 2.0) {
                if (MainThread.times % bosses.get(i).get(10) == 0) {
                    double s = Math.sin(angle);
                    double c = Math.cos(angle);
                    angle++;
                    xnew = (bosses.get(i).get(0) + imagesize) * c - (bosses.get(i).get(1) - imagesize) * s;
                    ynew = (bosses.get(i).get(0) + imagesize) * s + (bosses.get(i).get(1) - imagesize) * c;
                    deltax = bosses.get(i).get(0) - xnew;
                    deltay = bosses.get(i).get(1) - ynew;
                    dis = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
                    deltax /= dis;
                    deltay /= dis;

                    ArrayList<Double> shot = new ArrayList<>();
                    shot.add(bosses.get(i).get(0) + imagesize/2 - EnemyShot.imagesize);
                    shot.add(bosses.get(i).get(1) + imagesize/2 - EnemyShot.imagesize);
                    shot.add(0.0);
                    shot.add(0.0);
                    shot.add(0.0);
                    shot.add(0.0);
                    shot.add(deltax);
                    shot.add(deltay);
                    EnemyShot.shots.add(shot);
                }
            }
            bosses.get(i).set(3, 0.0);
        }
    }
}
