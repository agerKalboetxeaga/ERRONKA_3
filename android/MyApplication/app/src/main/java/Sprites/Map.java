package Sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Miscellaneous.Collision;
import Activities.GameActivity;
import Miscellaneous.RoomGen;

import java.util.ArrayList;

/**
 * Handles the drawing and generation of the map in the game, in a similar way the doors do,
 * checks the grid in order to save the rooms where the player has been, seen and not entered, as well of showing where the player is now.
 */
public class Map {
    public static Bitmap[] images;
    public static int imagesize;
    public static double d;
    public static ArrayList<ArrayList<Integer>> seenrooms = new ArrayList<>();

    public Map(Bitmap[] bmp) {
        images = bmp;
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(images[i], (int) ((GameActivity.height * GameActivity.ratio / 0.5) * images[i].getWidth()), (int) ((GameActivity.height * GameActivity.ratio / 0.5) * images[i].getHeight()), false);
        }
        imagesize = images[0].getHeight();
    }

    public void draw(Canvas canvas) {
        if (MapButton.ispressed == 1) {
            for (int i = 0; i < seenrooms.size(); i++){
                    canvas.drawBitmap(images[seenrooms.get(i).get(2)], (int) (-imagesize * seenrooms.get(i).get(0) + GameActivity.width/2) + (Collision.roompos.get(0) * imagesize) , (int) (-imagesize * seenrooms.get(i).get(1) + GameActivity.height/2) + (Collision.roompos.get(1) * imagesize), null);
            }
        }else{
            for (int i = 0; i < seenrooms.size(); i++){
                d = Math.sqrt(Math.pow(seenrooms.get(i).get(0) - Collision.roompos.get(0),2) + Math.pow(seenrooms.get(i).get(1) - Collision.roompos.get(1),2));
                if (d < 2.5){
                    canvas.drawBitmap(images[seenrooms.get(i).get(2)], (int) (-imagesize * seenrooms.get(i).get(0) + GameActivity.width/11) + (Collision.roompos.get(0) * imagesize) , (int) (-imagesize * seenrooms.get(i).get(1) + GameActivity.height/4.5) + (Collision.roompos.get(1) * imagesize), null);
                }

            }
        }
    }

    public static void generate() {
        for (int i = 0; i < RoomGen.map.size(); i++) {
            int visitedrrom = 0;
            int seenroom = 0;
            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1)) {
                for (int k = 0; k < seenrooms.size(); k++) {
                    if (seenrooms.get(k).get(0) == RoomGen.map.get(i).get(0).get(0) && seenrooms.get(k).get(1) == RoomGen.map.get(i).get(0).get(1)) {
                        visitedrrom = 1;
                            if(seenrooms.get(k).get(2) == 1){
                                seenrooms.get(k).set(2,0);
                            }
                    }
                    if(seenrooms.get(k).get(2) == 2){
                        seenrooms.get(k).set(2,0);
                    }
                }

                if (visitedrrom == 0) {
                    ArrayList<Integer> room = new ArrayList<>();
                    room.add(RoomGen.map.get(i).get(0).get(0));
                    room.add(RoomGen.map.get(i).get(0).get(1));
                    room.add(0);
                    seenrooms.add(room);
                }
            }

            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1) + 1) {
                for (int k = 0; k < seenrooms.size(); k++) {
                    if (seenrooms.get(k).get(0) == RoomGen.map.get(i).get(0).get(0) && seenrooms.get(k).get(1) == RoomGen.map.get(i).get(0).get(1)) {
                        seenroom = 1;
                    }
                }

                if (seenroom == 0) {
                    ArrayList<Integer> room = new ArrayList<>();
                    room.add(RoomGen.map.get(i).get(0).get(0));
                    room.add(RoomGen.map.get(i).get(0).get(1));
                    room.add(1);
                    seenrooms.add(room);
                }
            }

            seenroom = 0;
            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1) - 1) {
                for (int k = 0; k < seenrooms.size(); k++) {
                    if (seenrooms.get(k).get(0) == RoomGen.map.get(i).get(0).get(0) && seenrooms.get(k).get(1) == RoomGen.map.get(i).get(0).get(1)) {
                        seenroom = 1;
                    }
                }

                if (seenroom == 0) {
                    ArrayList<Integer> room = new ArrayList<>();
                    room.add(RoomGen.map.get(i).get(0).get(0));
                    room.add(RoomGen.map.get(i).get(0).get(1));
                    room.add(1);
                    seenrooms.add(room);
                }
            }

            seenroom = 0;
            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) + 1 && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1)) {
                for (int k = 0; k < seenrooms.size(); k++) {
                    if (seenrooms.get(k).get(0) == RoomGen.map.get(i).get(0).get(0) && seenrooms.get(k).get(1) == RoomGen.map.get(i).get(0).get(1)) {
                        seenroom = 1;
                    }
                }

                if (seenroom == 0) {
                    ArrayList<Integer> room = new ArrayList<>();
                    room.add(RoomGen.map.get(i).get(0).get(0));
                    room.add(RoomGen.map.get(i).get(0).get(1));
                    room.add(1);
                    seenrooms.add(room);
                }
            }

            seenroom = 0;
            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) - 1 && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1)) {
                for (int k = 0; k < seenrooms.size(); k++) {
                    if (seenrooms.get(k).get(0) == RoomGen.map.get(i).get(0).get(0) && seenrooms.get(k).get(1) == RoomGen.map.get(i).get(0).get(1)) {
                        seenroom = 1;
                    }
                }

                if (seenroom == 0) {
                    ArrayList<Integer> room = new ArrayList<>();
                    room.add(RoomGen.map.get(i).get(0).get(0));
                    room.add(RoomGen.map.get(i).get(0).get(1));
                    room.add(1);
                    seenrooms.add(room);
                }
            }

            if (RoomGen.map.get(i).get(0).get(0) == Collision.roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == Collision.roompos.get(1)) {
                for (int k = 0; k < seenrooms.size(); k++) {
                    if (seenrooms.get(k).get(0) == RoomGen.map.get(i).get(0).get(0) && seenrooms.get(k).get(1) == RoomGen.map.get(i).get(0).get(1)) {
                        seenrooms.get(k).set(2,2);
                    }
                }
            }
        }
    }
}

