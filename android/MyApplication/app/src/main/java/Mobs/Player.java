package Mobs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Miscellaneous.MainThread;

import java.util.ArrayList;

import Activities.GameActivity;
import Sprites.PlayerCross;

/**
 * Handles all player related variables, in orther to easily acces all the player data
 */
public class Player {
    private Bitmap[] images;
    public static double x, y, vx, vy, a, r, cadence, shotspeed, shotready, range, iters, health, inuse,damage,knockback,knockbackresistance,invulnerabilitytime;
    public static int imagecounter, section, imagesize;
    public ArrayList<Bitmap> direction = new ArrayList<>();

    public Player(Bitmap[] bmp) {
        //animation vars
        images = bmp;
        imagecounter = 0;
        section = 0;
        inuse = 0;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio) * images[i].getHeight()), (int) ((GameActivity.height * GameActivity.ratio) * images[i].getWidth()), false);
        }

        //Calc vars
        imagesize = images[0].getHeight();
        x = GameActivity.width/ 2.0 - imagesize/2;
        y = GameActivity.height/2.0 - imagesize/2;
        vx = 0;
        vy = 0;
        a = 10;
        r = 0.75;
        shotready = 0;
        iters = 0;

        //Stat vars
        damage = 2;
        cadence = 20;
        shotspeed = 15;
        range = 40;
        health = 10;
        knockback = 15;
        knockbackresistance =3;
        invulnerabilitytime = 30;
    }

    public void draw(Canvas canvas) {
        direction.clear();
        if (health > 0){
            for (int i = section; i < (section + 12); i++) {
                direction.add(images[i]);
            }

            if (MainThread.times % 4 == 0) {
                if (PlayerCross.pressed == 0) {
                    imagecounter = 0;
                } else {
                    if (imagecounter == direction.size() - 1) {
                        imagecounter = 0;
                    } else {
                        imagecounter++;
                    }
                }
            }

            canvas.drawBitmap(direction.get(imagecounter), (int) (x), (int) (y), null);
        }
        if (health <= 0){
            canvas.drawBitmap(images[images.length - 1], (int) (x), (int) (y), null);
        }

    }

}


