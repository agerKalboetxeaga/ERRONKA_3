package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.GameView;

public class MapButton {
    public static Bitmap image;
    public static int imagesize;
    public static double mleft,mright,mtop,mbot,iter,buttonready,timebetween,ispressed;


    public MapButton(Bitmap bmp) {
        image = bmp;
        image = Bitmap.createScaledBitmap(image, (int) ((GameActivity.height * GameActivity.ratio) * image.getWidth()), (int) ((GameActivity.height * GameActivity.ratio) * image.getHeight()), false);
        imagesize = image.getHeight();
        mleft = GameActivity.width * 0.95 - imagesize/2;
        mright = GameActivity.width * 0.95- imagesize/2 + imagesize;
        mtop = GameActivity.height * 0.1- imagesize/2;
        mbot = GameActivity.height * 0.1- imagesize/2 + imagesize;
        timebetween = 50;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, (int) mleft , (int) mtop, null);
    }

    public void update() {
        if (buttonready == 0) {
            iter++;
            if (iter >= timebetween) {
                iter = 0;
                buttonready = 1;
            }
        }

        if (buttonready == 1){
            if ((GameView.xm >= mleft && GameView.xm <= mright && GameView.ym >=  mtop && GameView.ym <= mbot)){
                if  (ispressed == 1){
                    ispressed = 0;
                }else{
                    ispressed = 1;
                }
                buttonready = 0;
            }

        }
    }

}
