package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;

public class Paper {
    public Bitmap image;
    public static int paper,imagesize;

    public Paper(Bitmap bmp) {
        image = bmp;
        image = Bitmap.createScaledBitmap(image, (int) ((GameActivity.height * GameActivity.ratio/0.4) * image.getWidth()), (int) ((GameActivity.height * GameActivity.ratio/0.4) * image.getHeight()), false);
        imagesize = image.getHeight();
    }

    public void draw(Canvas canvas) {
        if (paper == 1){
            canvas.drawBitmap(image, GameActivity.width/2- imagesize/2, GameActivity.height/2 - imagesize/2, null);
        }
    }
}
