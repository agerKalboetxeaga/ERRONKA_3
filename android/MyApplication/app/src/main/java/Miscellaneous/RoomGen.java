package Miscellaneous;

import java.util.ArrayList;
import java.util.Random;

import Activities.GameActivity;
import Sprites.Item;
import Sprites.Rock;

/**
 * Handles the generation of the rooms in the game, this is done by creating
 * an MultiDimensional arraylist on every new start of the game, in witch all the needed variables for the rooms to be generated,
 * using the pseudo random number generator off java.
 */

public class RoomGen {
    public static Random random = new Random();
    public static ArrayList<ArrayList<ArrayList<Integer>>> map = new ArrayList<>();
    public static int x, y, iter;

    public static void generate() {
        iter = 0;
        map.clear();
        int roomnum = random.nextInt((50 - 20) + 1) + 20;

        for (int z = 0; z < roomnum; z++){
            int isroom = 0;
            int selector = (int) Math.round(Math.random());

            ArrayList<ArrayList<Integer>> room = new ArrayList<>();
            ArrayList<Integer> pos = new ArrayList<>();
            ArrayList<ArrayList<Integer>> rocks;
            ArrayList<Integer> rocksy = new ArrayList<>();
            ArrayList<Integer> rocksx = new ArrayList<>();
            ArrayList<Integer> rocksskin = new ArrayList<>();
            ArrayList<Integer> spider = new ArrayList<>();
            ArrayList<Integer> bat = new ArrayList<>();
            ArrayList<Integer> turret = new ArrayList<>();
            ArrayList<Integer> goldenroom = new ArrayList<>();


            pos.add(0);
            pos.add(0);

            if (!map.isEmpty()) {
                pos.set(0, map.get(iter - 1).get(0).get(0));
                pos.set(1, map.get(iter - 1).get(0).get(1));
                pos.set(selector, pos.get(selector) + (random.nextBoolean() ? 1 : -1));
            }

            room.add(pos);
            rocks = generatexy();

            try {
                for (int k = 0; k < rocks.get(0).size(); k++) {
                    rocksx.add(rocks.get(0).get(k));
                    rocksy.add(rocks.get(1).get(k));
                    rocksskin.add(rocks.get(2).get(k));
                }
            } catch (Exception e) {
            }

            room.add(rocksx);
            room.add(rocksy);
            room.add(rocksskin);
            spider.add(random.nextInt((3 - 0) + 1));
            bat.add(random.nextInt((3 - 0) + 1));
            turret.add(random.nextInt((3 - 0) + 1));
            room.add(spider);
            room.add(bat);
            room.add(turret);

            if (iter % 6 == 0 && iter != 0) {
                goldenroom.add(1);
                goldenroom.add((1 + (int) (Math.random() * ((Item.itemnumber - 1) + 1))));

            } else {
                goldenroom.add(0);
                goldenroom.add(0);
            }

            room.add(goldenroom);

            for (int k = 0; k < map.size(); k++) {
                if (room.get(0).equals(map.get(k).get(0))) {
                    isroom = 1;
                }
            }

            if (isroom == 0) {
                map.add(room);
                iter++;
            }
        }

        map.get(map.size()-1).get(7).set(0,2);
        map.get(map.size()-1).get(7).set(1,1);

        for (int i = 0; i < map.size(); i++) {
            if ((map.get(i).get(0).get(0) == 0 && map.get(i).get(0).get(1) == 0) || map.get(i).get(7).get(0) == 1 || map.get(i).get(7).get(0) == 2) {
                map.get(i).get(1).clear();
                map.get(i).get(2).clear();
                map.get(i).get(3).clear();
                map.get(i).get(4).set(0, 0);
                map.get(i).get(5).set(0, 0);
                map.get(i).get(6).set(0, 0);
            }
        }

    }

    public static ArrayList<ArrayList<Integer>> generatexy() {
        ArrayList<ArrayList<Integer>> rocks = new ArrayList<>();
        ArrayList<Integer> rocksy = new ArrayList<>();
        ArrayList<Integer> rocksx = new ArrayList<>();
        ArrayList<Integer> rocksskin = new ArrayList<>();


        for (int i = 0; i < (random.nextInt(Rock.cmax - Rock.cmin) + Rock.cmin); i++) {
            int isalready = 0;
            x = random.nextInt(GameActivity.width / Rock.imagesize - 2) + 1;
            y = random.nextInt(GameActivity.height / Rock.imagesize - 1) + 1;
            if (x != ((GameActivity.width / Rock.imagesize) / 2) && y != (int) ((GameActivity.height / Rock.imagesize) / 2.0) && y != Math.round((GameActivity.height / Rock.imagesize) / 2.0)) {
                for (int k = 0; k < rocksx.size(); k++) {
                    if (rocksx.get(k) == x && rocksy.get(k) == y) {
                        isalready = 1;
                    }
                }
                if (isalready == 0) {
                    rocksx.add(x);
                    rocksy.add(y);
                    rocksskin.add(random.nextInt(3 - 0));
                    rocks.add(rocksx);
                    rocks.add(rocksy);
                    rocks.add(rocksskin);
                }
            }
        }
        return rocks;
    }
}
