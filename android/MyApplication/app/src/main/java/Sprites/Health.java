package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Mobs.Player;

/**
 * Handles the positioning of the heart sprites on the game, making them stay in lines of ten
 */
public class Health {
    public Bitmap image;
    public double x, y, lines,rows;

    public Health(Bitmap bmp) {
        image = bmp;
        image = Bitmap.createScaledBitmap(image, (int)(((GameActivity.height * GameActivity.ratio) * image.getWidth())/1.7) , (int)(((GameActivity.height * GameActivity.ratio) * image.getHeight())/1.7) , false);
        rows = 10;

    }
    public void draw(Canvas canvas) {
        lines = 0;
        x = GameActivity.width * 0.03;
        y = GameActivity.height * 0.01;

        for (int i = 0; i < Player.health; i++) {
            if (i % rows == 0 &&  i != 0) {
                lines++;
                x -=rows * (image.getWidth()*1.2) ;
                y +=image.getWidth()*1.2;
            }
            canvas.drawBitmap(image, (int)((x)+(i*(image.getWidth()*1.2))), (int)y, null);
        }
    }

}




