package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;

public class Dark {
    public Bitmap image;
    public static int darken;

    public Dark(Bitmap bmp) {
        image = bmp;
        image = Bitmap.createScaledBitmap(image, GameActivity.width, GameActivity.height, false);
    }

    public void draw(Canvas canvas) {
        if (darken == 1){
            canvas.drawBitmap(image, 0, 0, null);
        }
    }

}