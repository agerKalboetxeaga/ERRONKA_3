package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.MainThread;

import java.util.ArrayList;

/**
 * By cheking the "RoomGen" map array draws the detected item
 */
public class Item {
    public Bitmap[] images;
    public Bitmap[] imageitem = new Bitmap[6];
    public static ArrayList<ArrayList<Double>> items = new ArrayList<>();
    public static int imagesize,topend,botend,itemnumber;
    public Item(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio/1.4) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio/1.4) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
        itemnumber = (images.length/6);
    }

    public void draw(Canvas canvas) {
        for (int k = 0; k < items.size(); k++) {
            topend = (int) (items.get(k).get(3) * 6) - 1;
            botend = (int)(topend - 5);
            int iter = 0;
            for(int w = botend; w <= topend; w++){
                imageitem[iter] = images[w];
                iter++;
            }

        for (int i = 0; i < items.size(); i++) {
            if (MainThread.times % 8 == 0) {
                if (items.get(i).get(2) < imageitem.length-1) {
                    items.get(i).set(2, items.get(i).get(2) + 1);
                } else {
                    items.get(i).set(2, 0.0);
                }
            }
            canvas.drawBitmap(imageitem[(int) Math.round(items.get(i).get(2))], Math.round(items.get(i).get(0)), Math.round(items.get(i).get(1)), null);
        }
    }
    }


}
