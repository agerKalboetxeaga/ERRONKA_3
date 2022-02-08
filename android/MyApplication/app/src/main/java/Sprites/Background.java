package Sprites;

import android.graphics.Bitmap;

import android.graphics.Canvas;

public class Background {
    public Bitmap image;
    public int x, y;

    public Background(Bitmap bmp, int screenX, int screenY) {
        image = bmp;
        x = screenX;
        y = screenY;
        image = Bitmap.createScaledBitmap(image, screenX, screenY, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);
    }

    public void update() {
    }
}