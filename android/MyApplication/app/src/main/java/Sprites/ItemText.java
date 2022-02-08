package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Mobs.Player;

public class ItemText {
        public static Bitmap[] images;
        public static int imagewidht,imageheight,showtext = 1,iter,time = 100,itemid;

    public ItemText(Bitmap[] bmp) {
            images = bmp;
            for (int i = 0; i < images.length; i++) {
                images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio/1.8) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio/1.8) * images[i].getHeight()), false);
            }
            imagewidht = images[0].getWidth();
            imageheight = images[0].getHeight();
        }

    public void draw(Canvas canvas) {
        if (showtext == 0) {
            canvas.drawBitmap(images[itemid],(int)(Player.x - imagewidht/2 + Player.imagesize/2), (int)(Player.y - imageheight) , null);
        }
    }

    public void update() {
        if (showtext == 0) {
            iter++;
            if (iter >= time) {
                iter = 0;
                showtext = 1;
            }
        }
    }
}
