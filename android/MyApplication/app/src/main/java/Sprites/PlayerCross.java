package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Activities.GameActivity;
import Miscellaneous.GameView;
import Mobs.Player;

/**
 * Handles the player positioning by checking the "GameView" ontouchevent variables
 */
public class PlayerCross {
    public static Bitmap image;
    public static int imagesize, pressed, enabled;
    public static double distance, deltax, deltay;

    public PlayerCross(Bitmap bmp) {
        image = bmp;
        image = Bitmap.createScaledBitmap(image, (int) ((GameActivity.height * GameActivity.ratio * 1.35) * image.getWidth()), (int) ((GameActivity.height * GameActivity.ratio * 1.35) * image.getHeight()), false);
        imagesize = image.getHeight();
    }

    public void draw(Canvas canvas) {
        if (enabled == 0) {
            if (pressed == 1) {
                canvas.drawBitmap(image, (int) (GameView.x0) - imagesize / 2, (int) (GameView.y0) - imagesize / 2, null);
            }
        }
    }

    public void update() {
        if (enabled == 0) {
            if (pressed == 1) {
                deltax = GameView.x0 - GameView.x;
                deltay = GameView.y0 - GameView.y;
                distance = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));

                if (distance > 50 && pressed == 1 && Math.abs(Player.vx) < Player.a && Math.abs(Player.vy) < Player.a) {
                    Player.vx = Player.vx - deltax / 20;
                    Player.vy = Player.vy - deltay / 20;

                    if (Player.inuse == 0) {
                        if (Math.abs(deltax) > Math.abs(deltay)) {
                            if (Player.vx > 0) {
                                Player.section = 12;
                            }
                            if (Player.vx < 0) {
                                Player.section = 36;
                            }
                        }

                        if (Math.abs(deltay) > Math.abs(deltax)) {
                            if (Player.vy > 0) {
                                Player.section = 0;
                            }
                            if (Player.vy < 0) {
                                Player.section = 24;
                            }
                        }
                    }
                } else {
                    Player.vx = Player.vx * Player.r;
                    Player.vy = Player.vy * Player.r;
                }
                Player.x += Player.vx;
                Player.y += Player.vy;

            } else {
                Player.vx = Player.vx * Player.r;
                Player.vy = Player.vy * Player.r;
                Player.x += Player.vx;
                Player.y += Player.vy;
            }
        }
    }
}

