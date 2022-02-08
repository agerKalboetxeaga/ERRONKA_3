package Miscellaneous;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Sprites.Paper;

/**
 * Handles kills and points and how the are added or removed
 */
public class Point {
    public Bitmap[] images;
    public static double imagesize;
    public static int points, kills;
    public static double mleft,mtop;


    public Point(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio/2.7) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio/2.7) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
        mleft = GameActivity.width * 0.89;
        mtop = GameActivity.height * 0.02;
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < String.valueOf(points).length();i++){
            canvas.drawBitmap(images[Character.getNumericValue(String.valueOf(points).charAt(i))],(int)((mleft + (imagesize/1.4 * i)) - (String.valueOf(points).length() * imagesize/1.4)), (int)mtop, null);
        }
        if (Paper.paper ==1){
            for (int i = 0; i < String.valueOf(points).length();i++){
                canvas.drawBitmap(images[Character.getNumericValue(String.valueOf(points).charAt(i))],(int)((GameActivity.width/1.8 + (imagesize/1.9 * i)) - (String.valueOf(points).length() * imagesize/1.9)), (int)(GameActivity.height/2.35), null);
            }
            for (int i = 0; i < String.valueOf(kills).length();i++){
                canvas.drawBitmap(images[Character.getNumericValue(String.valueOf(kills).charAt(i))],(int)((GameActivity.width/1.8 + (imagesize/1.9 * i)) - (String.valueOf(kills).length() * imagesize/1.9)), (int)(GameActivity.height/3.4), null);
            }

            for (int i = 0; i < String.valueOf(Timer.seconds).length();i++){
                canvas.drawBitmap(images[Character.getNumericValue(String.valueOf(Timer.seconds).charAt(i))],(int)((GameActivity.width/1.8 + (imagesize/1.9 * i)) - (String.valueOf(Timer.seconds).length() * imagesize/1.9)), (int)(GameActivity.height/2.8), null);
            }
        }
    }
}
