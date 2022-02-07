package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

import Activities.GameActivity;

/**
 * By checking the "roomGen" map array, knows where to draw all the rocks on every room
 */
public class Rock {

    public Bitmap images[];
    public static int cmax, cmin, imagesize;

    public static ArrayList<Integer> rocksx = new ArrayList<>();
    public static ArrayList<Integer> rocksy = new ArrayList<>();
    public static ArrayList<Integer> rocksskin = new ArrayList<>();

    public Rock(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio / 1.17) * images[i].getHeight()), (int) ((GameActivity.height * GameActivity.ratio / 1.17) * images[i].getWidth()), false);
        }
        imagesize = images[0].getHeight();
        cmax = 200;
        cmin = 1;
        rocksx.clear();
        rocksy.clear();
        rocksskin.clear();

    }

    public void draw(Canvas canvas) {
        try {
            for (int i = 0; i <= rocksx.size(); i++) {
                canvas.drawBitmap(images[rocksskin.get(i)], Math.round(rocksx.get(i) * imagesize), Math.round(rocksy.get(i) * imagesize), null);
            }
        } catch (Exception e) {
        }
    }

}


