package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Mobs.Player;

import Mobs.Boss;
import Mobs.Enemy1;
import Mobs.Enemy3;

public class Shadow {
    public Bitmap image;

    public Shadow(Bitmap bmp) {
        image = bmp;

    }

    public void draw(Canvas canvas) {
        image = Bitmap.createScaledBitmap(image, Player.imagesize, Player.imagesize, false);
        canvas.drawBitmap(image, (int) Player.x, (int) Player.y+ Player.imagesize/2, null);
        image = Bitmap.createScaledBitmap(image, Enemy1.imagesize, Enemy1.imagesize, false);
        for(int i = 0; i < Enemy1.enemies1.size(); i++){
            canvas.drawBitmap(image,Math.round(Enemy1.enemies1.get(i).get(0)) , Math.round(Enemy1.enemies1.get(i).get(1) + Enemy1.imagesize/4), null);
        }
        image = Bitmap.createScaledBitmap(image, Enemy3.imagesize, Enemy3.imagesize, false);
        for(int i = 0; i < Enemy3.enemies3.size(); i++){
            canvas.drawBitmap(image,Math.round(Enemy3.enemies3.get(i).get(0)) , Math.round(Enemy3.enemies3.get(i).get(1) + Enemy3.imagesize/4), null);
        }
        image = Bitmap.createScaledBitmap(image, Item.imagesize, Item.imagesize, false);
        for(int i = 0; i < Item.items.size();i++){
            canvas.drawBitmap(image,Math.round(Item.items.get(i).get(0)) , Math.round(Item.items.get(i).get(1) + Item.imagesize/2), null);
        }
        image = Bitmap.createScaledBitmap(image, (int)(Boss.imagesize), (int)(Boss.imagesize), false);
        for(int i = 0; i < Boss.bosses.size();i++){
            canvas.drawBitmap(image,Math.round(Boss.bosses.get(i).get(0)) , Math.round(Boss.bosses.get(i).get(1) + Boss.imagesize/6), null);
        }
    }

    public void update() {}
}