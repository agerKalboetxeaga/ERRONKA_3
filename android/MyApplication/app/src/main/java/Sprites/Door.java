package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Miscellaneous.Collision;
import Activities.GameActivity;
import Miscellaneous.RoomGen;

/**
 * Handles the positioning of the doors on the game, this works by checking the grid generated by "roomGen"
 * and drawing a door where a colliding room is detected
 */
public class Door {
    public Bitmap[] images;
    public static double imagesize;

    public Door(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio / 0.8) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio / 0.8) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < RoomGen.map.size(); i++) {
            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1) - 1) {
                if (RoomGen.map.get(i).get(7).get(0) == 0) {
                    canvas.drawBitmap(images[1], (int) (GameActivity.width / 2 - imagesize / 2), (int) (Collision.wbot - imagesize / 5.4), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 1) {
                    canvas.drawBitmap(images[5], (int) (GameActivity.width / 2 - imagesize / 2), (int) (Collision.wbot - imagesize / 5.4), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 2) {
                    canvas.drawBitmap(images[9], (int) (GameActivity.width / 2 - imagesize / 2), (int) (Collision.wbot - imagesize / 5.4), null);
                }
            }

            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1) + 1) {

                if (RoomGen.map.get(i).get(7).get(0) == 0) {
                    canvas.drawBitmap(images[0], (int) (GameActivity.width / 2 - imagesize / 2), (int) (Collision.wtop - imagesize / 1.3), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 1) {
                    canvas.drawBitmap(images[4], (int) (GameActivity.width / 2 - imagesize / 2), (int) (Collision.wtop - imagesize / 1.3), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 2) {
                    canvas.drawBitmap(images[8], (int) (GameActivity.width / 2 - imagesize / 2), (int) (Collision.wtop - imagesize / 1.3), null);
                }
            }

            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) - 1 && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1)) {
                if (RoomGen.map.get(i).get(7).get(0) == 0) {
                    canvas.drawBitmap(images[2], (int) (Collision.wright - imagesize / 3), (int) (GameActivity.height / 2 - imagesize / 2), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 1) {
                    canvas.drawBitmap(images[6], (int) (Collision.wright - imagesize / 3), (int) (GameActivity.height / 2 - imagesize / 2), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 2) {
                    canvas.drawBitmap(images[10], (int) (Collision.wright - imagesize / 3), (int) (GameActivity.height / 2 - imagesize / 2), null);
                }
            }

            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) + 1 && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1)) {
                if (RoomGen.map.get(i).get(7).get(0) == 0) {
                    canvas.drawBitmap(images[3], (int) (Collision.wleft - imagesize / 1.5), (int) (GameActivity.height / 2 - imagesize / 2), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 1) {
                    canvas.drawBitmap(images[7], (int) (Collision.wleft - imagesize / 1.5), (int) (GameActivity.height / 2 - imagesize / 2), null);
                }
                if (RoomGen.map.get(i).get(7).get(0) == 2) {
                    canvas.drawBitmap(images[11], (int) (Collision.wleft - imagesize / 1.5), (int) (GameActivity.height / 2 - imagesize / 2), null);
                }
            }
        }
    }
}
