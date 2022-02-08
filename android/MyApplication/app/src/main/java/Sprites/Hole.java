package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Miscellaneous.Collision;
import Activities.GameActivity;
import Miscellaneous.MainThread;
import Miscellaneous.RoomGen;

public class Hole {
    public Bitmap[] images;
    public static int imagesize, imagecounter, open;
    public static double x,y,hright,hleft,hbot,htop;
    public Hole(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio / 1.4) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio / 1.4) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
        x = (GameActivity.width/2 - imagesize/2);
        y = (GameActivity.height*0.2);

        hright = Hole.x - (Hole.imagesize * 0.2) + Hole.imagesize;
        hleft = Hole.x + (Hole.imagesize * 0.2);
        hbot = Hole.y - (Hole.imagesize * 0.2) + Hole.imagesize;
        htop = Hole.y + (Hole.imagesize * 0.2);
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < RoomGen.map.size(); i++) {
            if (RoomGen.map.get(i).get(7).get(0) == 2 && RoomGen.map.get(i).get(7).get(1) == 0 && RoomGen.map.get(i).get(0).equals(Collision.roompos)) {
                open = 1;
                if (imagecounter < 11){
                    if (MainThread.times % 4 == 0) {
                        canvas.drawBitmap(images[imagecounter], (int) x, (int) y, null);
                        imagecounter++;
                    }
                    canvas.drawBitmap(images[imagecounter], (int) x, (int) y, null);
                }else{
                    canvas.drawBitmap(images[11], (int) x, (int) y, null);
                }
            }else{
                open=0;
            }
        }
    }
}
