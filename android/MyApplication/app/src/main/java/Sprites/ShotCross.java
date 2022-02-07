package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.GameView;
import Mobs.Player;
import Mobs.PlayerShot;

import java.util.ArrayList;

/**
 * Handles the player shot direction by checking the "GameView" ontouchevent variables
 */
public class ShotCross {
    public static Bitmap image;
    public static double width, heigth;
    public static int enabled;

    public ShotCross(Bitmap bmp) {
        image = bmp;
        image = Bitmap.createScaledBitmap(image, (int) ((GameActivity.height * GameActivity.ratio * 1.35) * image.getWidth()), (int) ((GameActivity.height * GameActivity.ratio * 1.35) * image.getHeight()), false);
        width = GameActivity.width - (image.getWidth() + image.getWidth() * 0.3);
        heigth = GameActivity.height * 0.6;
    }

    public void draw(Canvas canvas) {
        if (enabled == 0) {
            canvas.drawBitmap(image, (int) width, (int) heigth, null);
        }
    }

    public void update() {
        if (enabled == 0) {
            //Cadence Calculator
            if (Player.shotready == 0) {
                Player.iters++;
                if (Player.iters >= Player.cadence) {
                    Player.iters = 0;
                    Player.shotready = 1;
                }
            }


            if (Player.shotready == 1) {
                //Up Shot
                if ((GameView.x >= ShotCross.width + (ShotCross.image.getWidth() / 2 - (ShotCross.image.getWidth() * 0.12)) && GameView.x <= ShotCross.width + (ShotCross.image.getWidth() / 2 + (ShotCross.image.getWidth() * 0.12)) && GameView.y >= ShotCross.heigth && GameView.y <= ShotCross.heigth + (ShotCross.image.getHeight() / 2 - (ShotCross.image.getHeight() * 0.1))) || (GameView.x1 >= ShotCross.width + (ShotCross.image.getWidth() / 2 - (ShotCross.image.getWidth() * 0.12)) && GameView.x1 <= ShotCross.width + (ShotCross.image.getWidth() / 2 + (ShotCross.image.getWidth() * 0.12)) && GameView.y1 >= ShotCross.heigth && GameView.y1 <= ShotCross.heigth + (ShotCross.image.getHeight() / 2 - (ShotCross.image.getHeight() * 0.1)))) {
                    Player.section = 24;
                    Player.inuse = 1;
                    ArrayList<Double> info = new ArrayList<>();
                    info.add(Player.x + PlayerShot.imagesize / 2);
                    info.add(Player.y);
                    info.add(1.0); // Direction
                    info.add(0.0); // Range
                    info.add(0.0); // Animation Iters
                    info.add(0.0); // Animation Image Pos In Array
                    PlayerShot.shots.add(info);
                    Player.shotready = 0;
                }
                //Right Shot
                else if ((GameView.x >= ShotCross.width + (ShotCross.image.getWidth() / 2 + (ShotCross.image.getWidth() * 0.1)) && GameView.x <= ShotCross.width + ShotCross.image.getWidth() && GameView.y >= ShotCross.heigth + (ShotCross.image.getHeight() / 2 - (ShotCross.image.getHeight() * 0.12)) && GameView.y <= ShotCross.heigth + (ShotCross.image.getHeight() / 2 + (ShotCross.image.getHeight() * 0.12))) || (GameView.x1 >= ShotCross.width + (ShotCross.image.getWidth() / 2 + (ShotCross.image.getWidth() * 0.1)) && GameView.x1 <= ShotCross.width + ShotCross.image.getWidth() && GameView.y1 >= ShotCross.heigth + (ShotCross.image.getHeight() / 2 - (ShotCross.image.getHeight() * 0.12)) && GameView.y1 <= ShotCross.heigth + (ShotCross.image.getHeight() / 2 + (ShotCross.image.getHeight() * 0.12)))) {
                    Player.section = 12;
                    Player.inuse = 1;
                    ArrayList<Double> info = new ArrayList<>();
                    info.add(Player.x + +PlayerShot.imagesize / 2);
                    info.add(Player.y + Player.imagesize / 4);
                    info.add(2.0); // Direction
                    info.add(0.0); // Range
                    info.add(0.0); // Animation Iters
                    info.add(0.0); // Animation Image Pos In Array
                    PlayerShot.shots.add(info);
                    Player.shotready = 0;
                }
                //Left Shot
                else if ((GameView.x >= ShotCross.width && GameView.x <= ShotCross.width + (ShotCross.image.getWidth() / 2 - (ShotCross.image.getWidth() * 0.1)) && GameView.y >= ShotCross.heigth + (ShotCross.image.getHeight() / 2 - (ShotCross.image.getHeight() * 0.12)) && GameView.y <= ShotCross.heigth + (ShotCross.image.getHeight() / 2 + (ShotCross.image.getHeight() * 0.12))) || (GameView.x1 >= ShotCross.width && GameView.x1 <= ShotCross.width + (ShotCross.image.getWidth() / 2 - (ShotCross.image.getWidth() * 0.1)) && GameView.y1 >= ShotCross.heigth + (ShotCross.image.getHeight() / 2 - (ShotCross.image.getHeight() * 0.12)) && GameView.y1 <= ShotCross.heigth + (ShotCross.image.getHeight() / 2 + (ShotCross.image.getHeight() * 0.12)))) {
                    Player.section = 36;
                    Player.inuse = 1;
                    ArrayList<Double> info = new ArrayList<>();
                    info.add(Player.x + PlayerShot.imagesize / 2);
                    info.add(Player.y + Player.imagesize / 4);
                    info.add(3.0); // Direction
                    info.add(0.0); // Range
                    info.add(0.0); // Animation Iters
                    info.add(0.0); // Animation Image Pos In Array
                    PlayerShot.shots.add(info);
                    Player.shotready = 0;
                }
                //Down Shot
                else if ((GameView.x >= ShotCross.width + (ShotCross.image.getWidth() / 2 - (ShotCross.image.getWidth() * 0.12)) && GameView.x <= ShotCross.width + (ShotCross.image.getWidth() / 2 + (ShotCross.image.getWidth() * 0.12)) && GameView.y >= ShotCross.heigth + (ShotCross.image.getHeight() / 2 + (ShotCross.image.getHeight() * 0.1)) && GameView.y <= (ShotCross.heigth + ShotCross.image.getHeight())) || (GameView.x1 >= ShotCross.width + (ShotCross.image.getWidth() / 2 - (ShotCross.image.getWidth() * 0.12)) && GameView.x1 <= ShotCross.width + (ShotCross.image.getWidth() / 2 + (ShotCross.image.getWidth() * 0.12)) && GameView.y1 >= ShotCross.heigth + (ShotCross.image.getHeight() / 2 + (ShotCross.image.getHeight() * 0.1)) && GameView.y1 <= (ShotCross.heigth + ShotCross.image.getHeight()))) {
                    Player.section = 0;
                    Player.inuse = 1;
                    ArrayList<Double> info = new ArrayList<>();
                    info.add(Player.x + PlayerShot.imagesize / 2);
                    info.add(Player.y + Player.imagesize / 2);
                    info.add(4.0); // Direction
                    info.add(0.0); // Range
                    info.add(0.0); // Animation Iters
                    info.add(0.0); // Animation Image Pos In Array
                    PlayerShot.shots.add(info);
                    Player.shotready = 0;
                } else {
                    Player.inuse = 0;
                }

            }
        }
    }
}