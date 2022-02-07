package Miscellaneous;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import Activities.GameActivity;
import Mobs.Boss;
import Mobs.Enemy1;
import Mobs.Enemy2;
import Mobs.Enemy3;
import Mobs.EnemyShot;
import Mobs.Player;
import Mobs.PlayerShot;
import Sprites.Dark;
import Sprites.Hole;
import Sprites.Item;
import Sprites.ItemText;
import Sprites.Map;
import Sprites.Paper;
import Sprites.PlayerCross;
import Sprites.Rock;
import Sprites.ShotCross;


public class Collision {
    public static int iter, dmgiter, damageready;
    public static int isroom = 0;
    public static ArrayList<Integer> roompos = new ArrayList<>();
    public static Random pos = new Random();
    public static double wleft = GameActivity.width * 0.06;
    public static double wright = GameActivity.width * 0.94;
    public static double wtop = GameActivity.height * 0.12;
    public static double wbot = GameActivity.height * 0.865;
    public static double deltabot, deltatop, deltaright, deltaleft;
    public static double pright, pleft, pbot, ptop, pmidx, pmidy;
    public static double e1left, e1right, e1top, e1bot;
    public static double sleft, sright, stop, sbot;
    public static double rright, rleft, rbot, rtop;
    public static double e3sleft, e3sright, e3stop, e3sbot;
    public static double deltax, deltay, distance;
    public static double e2left, e2right, e2top, e2bot;
    public static double ileft, iright, itop, ibot;
    public static double bleft, bright, btop, bbot;
    public static double[] deltas = {0.0, 0.0, 0.0, 0.0};

    public Collision() {
        roompos.clear();
        moveroom();
        roompos.add(0);
        roompos.add(0);
    }


    /**
     * Handles the collision and physic outcome for every case
     * This is done by comparing the length from each corner of the first object to the opposite
     * corner of the object that detected collision with,and then choosing the biggest
     * length in order to give the correct physic consequence.
     */

    public void update() {
        if (damageready == 0) {
            dmgiter++;
            if (dmgiter >= Player.invulnerabilitytime) {
                dmgiter = 0;
                damageready = 1;
            }
        }

        pright = Player.x - (Player.imagesize * 0.25) + Player.imagesize;
        pleft = Player.x + (Player.imagesize * 0.25);
        pbot = Player.y - (Player.imagesize * 0.1) + Player.imagesize;
        ptop = Player.y + (Player.imagesize * 0.30);
        pmidx = Player.x + Player.imagesize / 2.0;
        pmidy = Player.y + Player.imagesize / 2.0;




        //Player collision with walls
        deltabot = pbot - wbot;
        deltatop = wtop - ptop;
        deltaright = pright - wright;
        deltaleft = wleft - pleft;

        deltas[0] = deltabot;
        deltas[1] = deltatop;
        deltas[2] = deltaright;
        deltas[3] = deltaleft;

        if (pleft < wleft || pright > wright || ptop < wtop || pbot > wbot) {
            double max = Double.NEGATIVE_INFINITY;
            int maxid = 0;

            for (int k = 0; k < deltas.length; k++) {
                if (deltas[k] > max) {
                    max = deltas[k];
                    maxid = k;
                }
            }
            switch (maxid) {
                case 0:
                    Player.vx = 0;
                    Player.vy = 0;
                    Player.y = Player.y - Math.abs(max);
                    if (pmidx < ((GameActivity.width / 2) + Player.imagesize / 2) && pmidx > ((GameActivity.width / 2) - Player.imagesize / 2)) {
                        for (int i = 0; i < RoomGen.map.size(); i++) {
                            if (RoomGen.map.get(i).get(0).get(0) == roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == roompos.get(1) - 1) {
                                isroom = 1;
                            }
                        }
                        if (isroom == 1) {
                            Player.y = wtop - Player.imagesize / 2 + Player.imagesize / 2;
                            roompos.set(1, roompos.get(1) - 1);
                            Map.generate();
                            isroom = 0;
                            moveroom();
                            Log.d("TAG", roompos.toString());
                        }
                    }
                    break;

                case 1:
                    Player.vx = 0;
                    Player.vy = 0;
                    Player.y = Player.y + Math.abs(max);
                    if (pmidx < ((GameActivity.width / 2) + Player.imagesize / 2) && pmidx > ((GameActivity.width / 2) - Player.imagesize / 2)) {
                        for (int i = 0; i < RoomGen.map.size(); i++) {
                            if (RoomGen.map.get(i).get(0).get(0) == roompos.get(0) && RoomGen.map.get(i).get(0).get(1) == roompos.get(1) + 1) {
                                isroom = 1;
                            }
                        }
                        if (isroom == 1) {
                            Player.y = wbot - Player.imagesize / 2 - Player.imagesize / 2;
                            roompos.set(1, roompos.get(1) + 1);
                            Map.generate();
                            isroom = 0;
                            moveroom();
                            Log.d("TAG", roompos.toString());
                        }
                    }
                    break;

                case 2:
                    Player.vx = 0;
                    Player.vy = 0;
                    Player.x = Player.x - Math.abs(max);
                    if (pmidy < ((GameActivity.height / 2) + Player.imagesize / 2) && pmidy > ((GameActivity.height / 2) - Player.imagesize / 2)) {
                        for (int i = 0; i < RoomGen.map.size(); i++) {
                            if (RoomGen.map.get(i).get(0).get(0) == roompos.get(0) - 1 && RoomGen.map.get(i).get(0).get(1) == roompos.get(1)) {
                                isroom = 1;
                            }
                        }
                        if (isroom == 1) {
                            Player.x = wleft - Player.imagesize / 2 + Player.imagesize / 2;
                            roompos.set(0, roompos.get(0) - 1);
                            Map.generate();
                            isroom = 0;
                            moveroom();
                            Log.d("TAG", roompos.toString());
                        }
                    }
                    break;

                case 3:
                    Player.vx = 0;
                    Player.vy = 0;
                    Player.x = Player.x + Math.abs(max);
                    if (pmidy < ((GameActivity.height / 2) + Player.imagesize / 2) && pmidy > ((GameActivity.height / 2) - Player.imagesize / 2)) {
                        for (int i = 0; i < RoomGen.map.size(); i++) {
                            if (RoomGen.map.get(i).get(0).get(0) == roompos.get(0) + 1 && RoomGen.map.get(i).get(0).get(1) == roompos.get(1)) {
                                isroom = 1;
                            }
                        }
                        if (isroom == 1) {
                            Player.x = wright - Player.imagesize / 2 - Player.imagesize / 2;
                            roompos.set(0, roompos.get(0) + 1);
                            Map.generate();
                            isroom = 0;
                            moveroom();
                            Log.d("TAG", roompos.toString());
                        }
                    }
                    break;
            }
        }

        //Enemy1 collision with walls
        if (Enemy1.enemies1.size() > 0) {
            for (int k = 0; k < Enemy1.enemies1.size(); k++) {
                e1left = Enemy1.enemies1.get(k).get(0) + (Enemy1.imagesize * 0.2);
                e1right = Enemy1.enemies1.get(k).get(0) - (Enemy1.imagesize * 0.2) + Enemy1.imagesize;
                e1top = Enemy1.enemies1.get(k).get(1) + (Enemy1.imagesize * 0.2);
                e1bot = Enemy1.enemies1.get(k).get(1) - (Enemy1.imagesize * 0.2) + Enemy1.imagesize;

                deltabot = e1bot - wbot;
                deltatop = wtop - e1top;
                deltaright = e1right - wright;
                deltaleft = wleft - e1left;

                deltas[0] = deltabot;
                deltas[1] = deltatop;
                deltas[2] = deltaright;
                deltas[3] = deltaleft;

                if (e1left < wleft || e1right > wright || e1top < wtop || e1bot > wbot) {
                    iter++;
                    if (iter > 100) {
                        iter = 0;
                        Enemy1.enemies1.get(k).set(2, 0.0);
                        Enemy1.enemies1.get(k).set(3, 0.0);
                    }

                    double max = Double.NEGATIVE_INFINITY;
                    int maxid = 0;
                    for (int w = 0; w < deltas.length; w++) {
                        if (deltas[w] > max) {
                            max = deltas[w];
                            maxid = w;
                        }
                    }
                    switch (maxid) {
                        case 0:
                            Enemy1.enemies1.get(k).set(1, Enemy1.enemies1.get(k).get(1) - (Math.abs(max)));
                            break;
                        case 1:
                            Enemy1.enemies1.get(k).set(1, Enemy1.enemies1.get(k).get(1) + (Math.abs(max)));
                            break;
                        case 2:
                            Enemy1.enemies1.get(k).set(0, Enemy1.enemies1.get(k).get(0) - (Math.abs(max)));
                            break;
                        case 3:
                            Enemy1.enemies1.get(k).set(0, Enemy1.enemies1.get(k).get(0) + (Math.abs(max)));
                            break;
                    }
                }
            }
        }
        // Player Shot collisions with walls
        if (PlayerShot.shots.size() > 0) {
            for (int k = 0; k < PlayerShot.shots.size(); k++) {
                sleft = PlayerShot.shots.get(k).get(0) + (PlayerShot.imagesize * 0.40);
                sright = PlayerShot.shots.get(k).get(0) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;
                stop = PlayerShot.shots.get(k).get(1) + (PlayerShot.imagesize * 0.40);
                sbot = PlayerShot.shots.get(k).get(1) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;

                if (sleft < wleft || sright > wright || stop < wtop || sbot > wbot) {
                    PlayerShot.shots.remove(k);
                }
            }
        }
        // Enemy3 shot collisions with walls
        if (EnemyShot.shots.size() > 0) {
            for (int k = 0; k < EnemyShot.shots.size(); k++) {
                e3sleft = EnemyShot.shots.get(k).get(0) + (EnemyShot.imagesize * 0.40);
                e3sright = EnemyShot.shots.get(k).get(0) - (EnemyShot.imagesize * 0.40) + EnemyShot.imagesize;
                e3stop = EnemyShot.shots.get(k).get(1) + (EnemyShot.imagesize * 0.40);
                e3sbot = EnemyShot.shots.get(k).get(1) - (EnemyShot.imagesize * 0.40) + EnemyShot.imagesize;

                if (e3sleft < wleft || e3sright > wright || e3stop < wtop || e3sbot > wbot) {
                    EnemyShot.shots.remove(k);
                }
            }
        }
        //Colisions with Rocks
        if (Rock.rocksx.size() > 0) {
            for (int i = 0; i < Rock.rocksx.size(); i++) {
                //Player colision
                rright = (Rock.rocksx.get(i) * Rock.imagesize) + Rock.imagesize;
                rleft = Rock.rocksx.get(i) * Rock.imagesize;
                rbot = (Rock.rocksy.get(i) * Rock.imagesize) + Rock.imagesize;
                rtop = Rock.rocksy.get(i) * Rock.imagesize;
                deltabot = ptop - rbot;
                deltatop = rtop - pbot;
                deltaright = pleft - rright;
                deltaleft = rleft - pright;

                deltas[0] = deltabot;
                deltas[1] = deltatop;
                deltas[2] = deltaright;
                deltas[3] = deltaleft;

                if (deltatop < 0 && deltabot < 0 && deltaleft < 0 && deltaright < 0) {
                    double max = Double.NEGATIVE_INFINITY;
                    int maxid = 0;

                    for (int k = 0; k < deltas.length; k++) {
                        if (deltas[k] > max) {
                            max = deltas[k];
                            maxid = k;
                        }
                    }
                    switch (maxid) {
                        case 0:
                            Player.vx = 0;
                            Player.vy = 0;
                            Player.vy = 0;
                            Player.y = Player.y + Math.abs(max);
                            break;
                        case 1:
                            Player.vx = 0;
                            Player.vy = 0;
                            Player.vy = 0;
                            Player.y = Player.y - Math.abs(max);
                            break;
                        case 2:
                            Player.vx = 0;
                            Player.vy = 0;
                            Player.vx = 0;
                            Player.x = Player.x + Math.abs(max);
                            break;
                        case 3:
                            Player.vx = 0;
                            Player.vy = 0;
                            Player.vx = 0;
                            Player.x = Player.x - Math.abs(max);
                            break;
                    }
                }

                // Player Shot colisions
                for (int k = 0; k < PlayerShot.shots.size(); k++) {
                    sleft = PlayerShot.shots.get(k).get(0) + (PlayerShot.imagesize * 0.40);
                    sright = PlayerShot.shots.get(k).get(0) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;
                    stop = PlayerShot.shots.get(k).get(1) + (PlayerShot.imagesize * 0.40);
                    sbot = PlayerShot.shots.get(k).get(1) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;

                    deltabot = stop - rbot;
                    deltatop = rtop - sbot;
                    deltaright = sleft - rright;
                    deltaleft = rleft - sright;

                    if (deltabot < 0 && deltatop < 0 && deltaright < 0 && deltaleft < 0) {
                        PlayerShot.shots.remove(k);
                    }
                }

                //Enemy3 Shot colisions
                for (int k = 0; k < EnemyShot.shots.size(); k++) {
                    e3sleft = EnemyShot.shots.get(k).get(0) + (EnemyShot.imagesize * 0.40);
                    e3sright = EnemyShot.shots.get(k).get(0) - (EnemyShot.imagesize * 0.40) + EnemyShot.imagesize;
                    e3stop = EnemyShot.shots.get(k).get(1) + (EnemyShot.imagesize * 0.40);
                    e3sbot = EnemyShot.shots.get(k).get(1) - (EnemyShot.imagesize * 0.40) + EnemyShot.imagesize;

                    deltabot = e3stop - rbot;
                    deltatop = rtop - e3sbot;
                    deltaright = e3sleft - rright;
                    deltaleft = rleft - e3sright;

                    if (deltabot < 0 && deltatop < 0 && deltaright < 0 && deltaleft < 0) {
                        EnemyShot.shots.remove(k);
                    }
                }

                //Enemy1 Colisions
                for (int k = 0; k < Enemy1.enemies1.size(); k++) {
                    e1left = Enemy1.enemies1.get(k).get(0) + (Enemy1.imagesize * 0.2);
                    e1right = Enemy1.enemies1.get(k).get(0) - (Enemy1.imagesize * 0.2) + Enemy1.imagesize;
                    e1top = Enemy1.enemies1.get(k).get(1) + (Enemy1.imagesize * 0.2);
                    e1bot = Enemy1.enemies1.get(k).get(1) - (Enemy1.imagesize * 0.2) + Enemy1.imagesize;

                    deltabot = e1top - rbot;
                    deltatop = rtop - e1bot;
                    deltaright = e1left - rright;
                    deltaleft = rleft - e1right;

                    deltas[0] = deltabot;
                    deltas[1] = deltatop;
                    deltas[2] = deltaright;
                    deltas[3] = deltaleft;

                    if (deltabot < 0 && deltatop < 0 && deltaright < 0 && deltaleft < 0) {
                        iter++;
                        if (iter > 100) {
                            iter = 0;
                            Enemy1.enemies1.get(k).set(2, 0.0);
                            Enemy1.enemies1.get(k).set(3, 0.0);
                        }

                        double max = Double.NEGATIVE_INFINITY;
                        int maxid = 0;
                        for (int w = 0; w < deltas.length; w++) {
                            if (deltas[w] > max) {
                                max = deltas[w];
                                maxid = w;
                            }
                        }

                        switch (maxid) {
                            case 0:
                                Enemy1.enemies1.get(k).set(1, Enemy1.enemies1.get(k).get(1) + (Math.abs(max)));
                                break;
                            case 1:
                                Enemy1.enemies1.get(k).set(1, Enemy1.enemies1.get(k).get(1) - (Math.abs(max)));
                                break;
                            case 2:
                                Enemy1.enemies1.get(k).set(0, Enemy1.enemies1.get(k).get(0) + (Math.abs(max)));
                                break;
                            case 3:
                                Enemy1.enemies1.get(k).set(0, Enemy1.enemies1.get(k).get(0) - (Math.abs(max)));
                                break;
                        }
                    }
                }
            }
        }
        //Collision with items
        if (Item.items.size() > 0) {
            for (int k = 0; k < Item.items.size(); k++) {
                ileft = Item.items.get(k).get(0) + (Item.imagesize * 0.2);
                iright = Item.items.get(k).get(0) - (Item.imagesize * 0.2) + Item.imagesize;
                itop = Item.items.get(k).get(1) + (Item.imagesize * 0.2);
                ibot = Item.items.get(k).get(1) - (Item.imagesize * 0.2) + Item.imagesize;

                deltabot = ptop - ibot;
                deltatop = itop - pbot;
                deltaright = pleft - iright;
                deltaleft = ileft - pright;

                if (deltabot < 0 && deltatop < 0 && deltaright < 0 && deltaleft < 0) {
                    switch ((int) Math.round(Item.items.get(k).get(3))) {
                        case 1:
                            Player.shotspeed += 5;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                        case 2:
                            Player.cadence *= 0.6;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                        case 3:
                            Player.health += 2;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                        case 4:
                            Player.range += 25;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                        case 5:
                            Player.damage += 2;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                        case 6:
                            Player.knockbackresistance *= 0.7;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                        case 7:
                            Player.knockback += 2;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                        case 8:
                            Player.a *= 1.3;
                            ItemText.itemid = (int) Math.round(Item.items.get(k).get(3) - 1);
                            ItemText.showtext = 0;
                            break;
                    }


                    Item.items.remove(k);
                    for (int w = 0; w < RoomGen.map.size(); w++) {
                        if (RoomGen.map.get(w).get(0).get(0) == roompos.get(0) && RoomGen.map.get(w).get(0).get(1) == roompos.get(1)) {
                            if (RoomGen.map.get(w).get(7).get(0) == 1) {
                                RoomGen.map.get(w).get(7).set(0, 0);
                            }
                        }
                    }
                }
            }
        }
        //Dmg and knock back Enemy1
        if (Enemy1.enemies1.size() > 0) {
            for (int i = 0; i < Enemy1.enemies1.size(); i++) {
                e1left = Enemy1.enemies1.get(i).get(0) + (Enemy1.imagesize * 0.2);
                e1right = Enemy1.enemies1.get(i).get(0) - (Enemy1.imagesize * 0.2) + Enemy1.imagesize;
                e1top = Enemy1.enemies1.get(i).get(1) + (Enemy1.imagesize * 0.2);
                e1bot = Enemy1.enemies1.get(i).get(1) - (Enemy1.imagesize * 0.2) + Enemy1.imagesize;

                for (int k = 0; k < PlayerShot.shots.size(); k++) {
                    sleft = PlayerShot.shots.get(k).get(0) + (PlayerShot.imagesize * 0.40);
                    sright = PlayerShot.shots.get(k).get(0) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;
                    stop = PlayerShot.shots.get(k).get(1) + (PlayerShot.imagesize * 0.40);
                    sbot = PlayerShot.shots.get(k).get(1) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;

                    deltabot = stop - e1bot;
                    deltatop = e1top - sbot;
                    deltaright = sleft - e1right;
                    deltaleft = e1left - sright;

                    if (deltabot < 0 && deltatop < 0 && deltaright < 0 && deltaleft < 0) {
                        deltax = (e1left + Enemy1.imagesize / 2) - (sleft + PlayerShot.imagesize / 2);
                        deltay = (e1top + Enemy1.imagesize / 2) - (stop + PlayerShot.imagesize / 2);
                        distance = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
                        deltax /= distance;
                        deltay /= distance;
                        for (int w = 0; w < Player.knockback; w++) {
                            Enemy1.enemies1.get(i).set(0, Enemy1.enemies1.get(i).get(0) + deltax * Player.knockback / 12);
                            Enemy1.enemies1.get(i).set(1, Enemy1.enemies1.get(i).get(1) + deltay * Player.knockback / 12);
                        }

                        PlayerShot.shots.remove(k);
                        Enemy1.enemies1.get(i).set(10, Enemy1.enemies1.get(i).get(10) - Player.damage);
                        if (Enemy1.enemies1.get(i).get(10) <= 0) {
                            Enemy1.enemies1.remove(i);
                            for (int w = 0; w < RoomGen.map.size(); w++) {
                                if (roompos.equals(RoomGen.map.get(w).get(0))) {
                                    RoomGen.map.get(w).get(4).set(0, RoomGen.map.get(w).get(4).get(0) - 1);
                                    Point.kills++;
                                    Point.points += 5;
                                }
                            }
                        }
                    }
                }

                deltabot = ptop - e1bot;
                deltatop = e1top - pbot;
                deltaright = pleft - e1right;
                deltaleft = e1left - pright;

                if (deltatop < 0 && deltabot < 0 && deltaleft < 0 && deltaright < 0) {
                    deltax = (pleft + Player.imagesize / 2) - (e1left + Enemy1.imagesize / 2);
                    deltay = (ptop + Player.imagesize / 2) - (e1top + Enemy1.imagesize / 2);
                    distance = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
                    deltax /= distance;
                    deltay /= distance;
                    Player.x = Player.x + deltax * Player.knockbackresistance;
                    Player.y = Player.y + deltay * Player.knockbackresistance;
                    if (damageready == 1) {
                        if (Player.health > 0){
                            Player.health -= Enemy1.enemies1.get(i).get(11);
                            if (Point.points >= 10) {
                                Point.points -= 10;
                            } else {
                                Point.points -= Point.points;
                            }
                        }
                        if (Player.health <= 0){
                            gameover();
                        }
                        damageready = 0;
                    }
                }
            }
        }
        //Dmg and knock back Enemy2
        if (Enemy2.enemies2.size() > 0) {
            for (int i = 0; i < Enemy2.enemies2.size(); i++) {
                e2left = Enemy2.enemies2.get(i).get(0) + (Enemy2.imagesize * 0.2);
                e2right = Enemy2.enemies2.get(i).get(0) - (Enemy2.imagesize * 0.2) + Enemy2.imagesize;
                e2top = Enemy2.enemies2.get(i).get(1) + (Enemy2.imagesize * 0.2);
                e2bot = Enemy2.enemies2.get(i).get(1) - (Enemy2.imagesize * 0.2) + Enemy2.imagesize;

                for (int k = 0; k < PlayerShot.shots.size(); k++) {
                    sleft = PlayerShot.shots.get(k).get(0) + (PlayerShot.imagesize * 0.40);
                    sright = PlayerShot.shots.get(k).get(0) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;
                    stop = PlayerShot.shots.get(k).get(1) + (PlayerShot.imagesize * 0.40);
                    sbot = PlayerShot.shots.get(k).get(1) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;

                    deltabot = stop - e2bot;
                    deltatop = e2top - sbot;
                    deltaright = sleft - e2right;
                    deltaleft = e2left - sright;

                    if (deltabot < 0 && deltatop < 0 && deltaleft < 0 && deltaright < 0) {
                        deltax = (e2left + Enemy2.imagesize / 2) - (sleft + PlayerShot.imagesize / 2);
                        deltay = (e2top + Enemy2.imagesize / 2) - (stop + PlayerShot.imagesize / 2);
                        distance = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
                        deltax /= distance;
                        deltay /= distance;
                        for (int w = 0; w < Player.knockback; w++) {
                            Enemy2.enemies2.get(i).set(0, Enemy2.enemies2.get(i).get(0) + deltax * Player.knockback / 12);
                            Enemy2.enemies2.get(i).set(1, Enemy2.enemies2.get(i).get(1) + deltay * Player.knockback / 12);
                        }

                        PlayerShot.shots.remove(k);
                        Enemy2.enemies2.get(i).set(11, Enemy2.enemies2.get(i).get(11) - Player.damage);
                        if (Enemy2.enemies2.get(i).get(11) <= 0) {
                            Enemy2.enemies2.remove(i);
                            for (int w = 0; w < RoomGen.map.size(); w++) {
                                if (roompos.equals(RoomGen.map.get(w).get(0))) {
                                    RoomGen.map.get(w).get(5).set(0, RoomGen.map.get(w).get(5).get(0) - 1);
                                    Point.kills++;
                                    Point.points += 10;
                                }
                            }
                        }
                    }
                }

                deltabot = ptop - e2bot;
                deltatop = e2top - pbot;
                deltaright = pleft - e2right;
                deltaleft = e2left - pright;

                if (deltatop < 0 && deltabot < 0 && deltaleft < 0 && deltaright < 0) {
                    deltax = (pleft + Player.imagesize / 2) - (e2left + Enemy2.imagesize / 2);
                    deltay = (ptop + Player.imagesize / 2) - (e2top + Enemy2.imagesize / 2);
                    distance = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
                    deltax /= distance;
                    deltay /= distance;
                    Player.x = Player.x + deltax * Player.knockbackresistance;
                    Player.y = Player.y + deltay * Player.knockbackresistance;
                    if (damageready == 1) {
                        if (Player.health > 0){
                            Player.health -= Enemy2.enemies2.get(i).get(12);
                            if (Point.points >= 10) {
                                Point.points -= 10;
                            } else {
                                Point.points -= Point.points;
                            }
                        }
                        if (Player.health <= 0){
                            gameover();
                        }
                        damageready = 0;
                    }
                }
            }
        }
        //Dmg and knock back Enemy3
        if (Enemy3.enemies3.size() > 0) {
            for (int i = 0; i < Enemy3.enemies3.size(); i++) {
                e3sleft = Enemy3.enemies3.get(i).get(0) + (Enemy3.imagesize * 0.2);
                e3sright = Enemy3.enemies3.get(i).get(0) - (Enemy3.imagesize * 0.2) + Enemy3.imagesize;
                e3stop = Enemy3.enemies3.get(i).get(1) + (Enemy3.imagesize * 0.2);
                e3sbot = Enemy3.enemies3.get(i).get(1) - (Enemy3.imagesize * 0.2) + Enemy3.imagesize;

                for (int k = 0; k < PlayerShot.shots.size(); k++) {
                    sleft = PlayerShot.shots.get(k).get(0) + (PlayerShot.imagesize * 0.40);
                    sright = PlayerShot.shots.get(k).get(0) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;
                    stop = PlayerShot.shots.get(k).get(1) + (PlayerShot.imagesize * 0.40);
                    sbot = PlayerShot.shots.get(k).get(1) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;

                    deltabot = stop - e3sbot;
                    deltatop = e3stop - sbot;
                    deltaright = sleft - e3sright;
                    deltaleft = e3sleft - sright;

                    if (deltabot < 0 && deltatop < 0 && deltaleft < 0 && deltaright < 0) {
                        PlayerShot.shots.remove(k);
                        Enemy3.enemies3.get(i).set(9, Enemy3.enemies3.get(i).get(9) - Player.damage);
                        if (Enemy3.enemies3.get(i).get(9) <= 0) {
                            Enemy3.enemies3.remove(i);
                            for (int w = 0; w < RoomGen.map.size(); w++) {
                                if (roompos.equals(RoomGen.map.get(w).get(0))) {
                                    RoomGen.map.get(w).get(6).set(0, RoomGen.map.get(w).get(6).get(0) - 1);
                                    Point.kills++;
                                    Point.points += 20;
                                }
                            }
                        }
                    }
                }

                deltabot = ptop - e3sbot;
                deltatop = e3stop - pbot;
                deltaright = pleft - e3sright;
                deltaleft = e3sleft - pright;

                if (deltatop < 0 && deltabot < 0 && deltaleft < 0 && deltaright < 0) {
                    deltax = (pleft + Player.imagesize / 2) - (e3sleft + Enemy3.imagesize / 2);
                    deltay = (ptop + Player.imagesize / 2) - (e3stop + Enemy3.imagesize / 2);
                    distance = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
                    deltax /= distance;
                    deltay /= distance;
                    Player.x = Player.x + deltax * Player.knockbackresistance;
                    Player.y = Player.y + deltay * Player.knockbackresistance;
                    if (damageready == 1) {
                        if (Player.health > 0){
                            Player.health -= Enemy3.enemies3.get(i).get(10);
                            if (Point.points >= 10) {
                                Point.points -= 10;
                            } else {
                                Point.points -= Point.points;
                            }
                        }
                        if (Player.health <= 0){
                            gameover();
                        }
                        damageready = 0;
                    }
                }
            }
        }
        //Enemy3 Shots dmg Player
        if (EnemyShot.shots.size() > 0) {
            for (int i = 0; i < EnemyShot.shots.size(); i++) {
                e3sleft = EnemyShot.shots.get(i).get(0) + (EnemyShot.imagesize * 0.40);
                e3sright = EnemyShot.shots.get(i).get(0) - (EnemyShot.imagesize * 0.40) + EnemyShot.imagesize;
                e3stop = EnemyShot.shots.get(i).get(1) + (EnemyShot.imagesize * 0.40);
                e3sbot = EnemyShot.shots.get(i).get(1) - (EnemyShot.imagesize * 0.40) + EnemyShot.imagesize;

                deltabot = e3stop - pbot;
                deltatop = ptop - e3sbot;
                deltaright = e3sleft - pright;
                deltaleft = pleft - e3sright;

                if (deltatop < 0 && deltabot < 0 && deltaleft < 0 && deltaright < 0) {
                    EnemyShot.shots.remove(i);
                    if (damageready == 1) {
                        if (Player.health > 0){
                            Player.health -= 1;
                            if (Point.points >= 10) {
                                Point.points -= 10;
                            } else {
                                Point.points -= Point.points;
                            }
                        }
                        if (Player.health <= 0){
                            gameover();
                        }
                        damageready = 0;
                    }
                }
            }
        }
        //Boss Collision
        if (Boss.bosses.size() > 0) {
            for (int i = 0; i < Boss.bosses.size(); i++) {
                bleft = Boss.bosses.get(i).get(0) + (Boss.imagesize * 0.2);
                bright = Boss.bosses.get(i).get(0) - (Boss.imagesize * 0.2) + Boss.imagesize;
                btop = Boss.bosses.get(i).get(1) + (Boss.imagesize * 0.2);
                bbot = Boss.bosses.get(i).get(1) - (Boss.imagesize * 0.2) + Boss.imagesize;

                for (int k = 0; k < PlayerShot.shots.size(); k++) {
                    sleft = PlayerShot.shots.get(k).get(0) + (PlayerShot.imagesize * 0.40);
                    sright = PlayerShot.shots.get(k).get(0) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;
                    stop = PlayerShot.shots.get(k).get(1) + (PlayerShot.imagesize * 0.40);
                    sbot = PlayerShot.shots.get(k).get(1) - (PlayerShot.imagesize * 0.40) + PlayerShot.imagesize;

                    deltabot = stop - bbot;
                    deltatop = btop - sbot;
                    deltaright = sleft - bright;
                    deltaleft = bleft - sright;

                    if (deltabot < 0 && deltatop < 0 && deltaleft < 0 && deltaright < 0) {
                        PlayerShot.shots.remove(k);
                        Boss.bosses.get(i).set(8, Boss.bosses.get(i).get(8) - Player.damage);
                        if (Boss.bosses.get(i).get(8) <= 0) {
                            Boss.bosses.remove(i);
                            for (int w = 0; w < RoomGen.map.size(); w++) {
                                if (roompos.equals(RoomGen.map.get(w).get(0))) {
                                    RoomGen.map.get(w).get(7).set(1, RoomGen.map.get(w).get(7).get(1) - 1);
                                    Point.kills++;
                                    Point.points += 50000;
                                }
                            }
                        }
                    }
                }

                deltabot = ptop - bbot;
                deltatop = btop - pbot;
                deltaright = pleft - bright;
                deltaleft = bleft - pright;

                if (deltatop < 0 && deltabot < 0 && deltaleft < 0 && deltaright < 0) {
                    deltax = (pleft + Player.imagesize / 2) - (bleft + Boss.imagesize / 2);
                    deltay = (ptop + Player.imagesize / 2) - (btop + Boss.imagesize / 2);
                    distance = Math.sqrt(Math.pow(deltax, 2) + Math.pow(deltay, 2));
                    deltax /= distance;
                    deltay /= distance;
                    Player.x = Player.x + deltax * Player.knockbackresistance*4;
                    Player.y = Player.y + deltay * Player.knockbackresistance*4;

                    if (damageready == 1) {
                        if (Player.health > 0){
                            Player.health -= 1;
                            if (Point.points >= 10) {
                                Point.points -= 10;
                            } else {
                                Point.points -= Point.points;
                            }
                        }
                        if (Player.health <= 0){
                            gameover();
                        }
                        damageready = 0;
                    }
                }
            }
        }
        //Hole Collision
        if (Hole.open == 1){
            deltabot = Hole.htop - pbot;
            deltatop = ptop - Hole.hbot;
            deltaright = Hole.hleft - pright;
            deltaleft = pleft - Hole.hright;
            if (deltatop < 0 && deltabot < 0 && deltaleft < 0 && deltaright < 0) {
                gameover();
            }
        }
    }

    public void moveroom() {
        Enemy1.enemies1.clear();
        Enemy2.enemies2.clear();
        Enemy3.enemies3.clear();
        EnemyShot.shots.clear();
        PlayerShot.shots.clear();
        Boss.bosses.clear();
        Item.items.clear();
        for (int w = 0; w < RoomGen.map.size(); w++) {
            if (RoomGen.map.get(w).get(0).equals(roompos)) {
                Rock.rocksx = RoomGen.map.get(w).get(1);
                Rock.rocksy = RoomGen.map.get(w).get(2);
                Rock.rocksskin = RoomGen.map.get(w).get(3);
                for (int z = 1; z < RoomGen.map.get(w).get(4).get(0); z++) {
                    ArrayList<Double> enemy1 = new ArrayList<>();
                    enemy1.add(GameActivity.width / 2.0 - Enemy1.imagesize / 2);
                    enemy1.add(GameActivity.height / 2.0 - Enemy1.imagesize / 2);
                    enemy1.add(0.0);
                    enemy1.add(0.0);
                    enemy1.add(0.0);
                    enemy1.add(0.0);
                    enemy1.add(0.0);
                    enemy1.add(0.0);
                    enemy1.add(Double.POSITIVE_INFINITY);
                    enemy1.add(Double.POSITIVE_INFINITY);
                    enemy1.add(10.0);
                    enemy1.add(1.0);
                    Enemy1.enemies1.add(enemy1);
                }
                for (int z = 1; z < RoomGen.map.get(w).get(5).get(0); z++) {
                    ArrayList<Double> enemy2 = new ArrayList<>();
                    enemy2.add(GameActivity.width / 2.0 - Enemy2.imagesize / 2);
                    enemy2.add(GameActivity.height / 2.0 - Enemy2.imagesize / 2);
                    enemy2.add(0.0);
                    enemy2.add(0.0);
                    enemy2.add(0.0);
                    enemy2.add(0.0);
                    enemy2.add(0.0);
                    enemy2.add(0.0);
                    enemy2.add(Double.POSITIVE_INFINITY);
                    enemy2.add(Double.POSITIVE_INFINITY);
                    enemy2.add(4.0);
                    enemy2.add(10.0);
                    enemy2.add(1.0);
                    Enemy2.enemies2.add(enemy2);
                }
                for (int z = 1; z < RoomGen.map.get(w).get(6).get(0); z++) {
                    ArrayList<Double> enemy3 = new ArrayList<>();
                    enemy3.add(pos.nextInt((int) (GameActivity.width * 0.85) - (int) (GameActivity.width * 0.06)) + GameActivity.width * 0.06);
                    enemy3.add(pos.nextInt((int) (GameActivity.height / 2.0 + Enemy3.imagesize / 2) - (int) (GameActivity.height / 2.0 - Enemy3.imagesize / 2)) + (GameActivity.height / 2.0 - Enemy3.imagesize));
                    enemy3.add(0.0);
                    enemy3.add(0.0);
                    enemy3.add(12.0);
                    enemy3.add(60.0);
                    enemy3.add(60.0);
                    enemy3.add(0.0);
                    enemy3.add(0.0);
                    enemy3.add(10.0);
                    enemy3.add(1.0);
                    Enemy3.enemies3.add(enemy3);
                }

                if (RoomGen.map.get(w).get(7).get(0) == 2) {
                    for (int z = 0; z < RoomGen.map.get(w).get(7).get(1); z++) {
                        ArrayList<Double> boss = new ArrayList<>();
                        boss.add((double) (GameActivity.width / 2 - Boss.imagesize / 2));//Boss pos x
                        boss.add((double) (GameActivity.height / 2 - Boss.imagesize / 2));//Boss pos y
                        boss.add(0.0);//Boss iter
                        boss.add(0.0);// Boss attackready
                        boss.add(0.0);// Time
                        boss.add(0.0);// Attack
                        boss.add(0.0);//Image imagecounter
                        boss.add(5.0);//Speed
                        boss.add(100.0);//Hp
                        boss.add(1.0);//Attack
                        boss.add(3.0);//AttackSpeed
                        boss.add(200.0);//Range
                        boss.add(20.0);//ShotSpeed
                        Boss.bosses.add(boss);
                    }
                }

                if (RoomGen.map.get(w).get(7).get(0) == 1) {
                    ArrayList<Double> item = new ArrayList<>();
                    item.add(GameActivity.width / 2.0 - Item.imagesize / 2);
                    item.add(GameActivity.height / 2.0 - Item.imagesize / 2);
                    item.add(0.0);
                    item.add((double) RoomGen.map.get(w).get(7).get(1));
                    Item.items.add(item);
                }
            }
        }
    }

    public void gameover(){
        Dark.darken = 1;
        Paper.paper = 1;
        PlayerCross.enabled = 1;
        ShotCross.enabled = 1;

    }
}

