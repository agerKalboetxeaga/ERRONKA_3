package Miscellaneous;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.myapplication.R;

import Activities.GameActivity;
import Mobs.Boss;
import Mobs.Enemy1;
import Mobs.Enemy2;
import Mobs.Enemy3;
import Mobs.EnemyShot;
import Mobs.Player;
import Mobs.PlayerShot;
import Sprites.Background;
import Sprites.Dark;
import Sprites.Door;
import Sprites.Health;
import Sprites.Hole;
import Sprites.Item;
import Sprites.ItemText;
import Sprites.Map;
import Sprites.MapButton;
import Sprites.Paper;
import Sprites.PlayerCross;
import Sprites.Rock;
import Sprites.Shadow;
import Sprites.ShotCross;
import Sprites.UserDropdown;

/**
 * This class handles the main thread of the game
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Timer timer;
    private Player player;
    private PlayerCross playerCross;
    private ShotCross shotCross;
    private Background background;
    private Shadow shadow;
    private PlayerShot playerShot;
    private Rock rock;
    private Health health;
    private Enemy1 enemy1;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private EnemyShot enemyShot;
    private Collision collision;
    private Item item;
    private Door door;
    private MapButton mapButton;
    private Map map;
    private ItemText itemText;
    private Point point;
    private Boss boss;
    private Hole hole;
    private Dark dark;
    private Paper paper;
    private UserDropdown userDropdown;

    BitmapFactory.Options opts = new BitmapFactory.Options();
    public static String path;
    private SQLiteDatabase data;
    private Context context;
    private Bitmap playerSpriteArray[];
    private Bitmap shotSpriteArray[];
    private Bitmap enemyShotSpriteArray[];
    private Bitmap enemy1SpriteArray[];
    private Bitmap enemy2SpriteArray[];
    private Bitmap enemy3SpriteArray[];
    private Bitmap rockSpriteArray[];
    private Bitmap itemSpriteArray[];
    private Bitmap doorSpriteArray[];
    private Bitmap mapSpriteArray[];
    private Bitmap itemTextArray[];
    private Bitmap pointsArray[];
    private Bitmap bossSpriteArray[];
    private Bitmap holeSpriteArray[];

    public static float x, y, x1, y1, x0, y0, xm, ym;

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        this.context = context;
        path = context.getFilesDir().getPath();
        timer = new Timer();
    }

    /**
     * Handles the multitouch control of the game
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointerCount;
        int action = event.getActionMasked() & event.getAction();
        int pointerIndex;
        int pointerId;

        if (action == MotionEvent.ACTION_DOWN) {
            x0 = event.getX();
            y0 = event.getY();
            x = event.getX();
            y = event.getY();
            xm = event.getX();
            ym = event.getY();

            if (x0 < GameActivity.width / 2) {
                PlayerCross.pressed = 1;
            }
        }

        if (action == MotionEvent.ACTION_POINTER_DOWN) {
            x1 = event.getX(1);
            y1 = event.getY(1);
        }

        if (action == MotionEvent.ACTION_MOVE) {
            pointerCount = event.getPointerCount();
            for (int i = 0; i < pointerCount; ++i) {
                pointerIndex = i;
                pointerId = event.getPointerId(pointerIndex);
                if (pointerId == 0) {
                    x = event.getX();
                    y = event.getY();
                }
                if (pointerId == 1) {
                    try {
                        x1 = event.getX(1);
                        y1 = event.getY(1);
                    } catch (Exception e) {
                    }
                }
            }
        }
        if (action == MotionEvent.ACTION_UP) {
            PlayerCross.pressed = 0;
            x1 = 0;
            y1 = 0;
            xm = 0;
            ym = 0;
        }

        if (action == MotionEvent.ACTION_POINTER_UP) {
            x1 = 0;
            y1 = 0;
        }
        return true;
    }

    /**
     * Initializes all needed assets on the start of the game
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        opts.inScaled = false;
        background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background), GameActivity.width, GameActivity.height);
        playerSpriteArray = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward0, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward1, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward2, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward3, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward4, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward5, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward6, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward7, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward8, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward9, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward10, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerfoward11, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright0, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright1, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright2, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright3, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright4, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright5, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright6, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright7, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright8, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright9, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright10, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerright11, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward0, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward1, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward2, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward3, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward4, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward5, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward6, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward7, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward8, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward9, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward10, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerbackward11, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft0, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft1, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft2, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft3, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft4, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft5, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft6, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft7, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft8, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft9, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft10, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerleft11, opts)
                , BitmapFactory.decodeResource(getResources(), R.drawable.playerdead, opts)};
        player = new Player(playerSpriteArray);

        shotSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.shot0, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.shot1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.shot2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.shot3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.shot4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.shot5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.shot6, opts)};
        playerShot = new PlayerShot(shotSpriteArray);

        enemyShotSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.eshot0, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.eshot1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.eshot2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.eshot3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.eshot4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.eshot5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.eshot6, opts)};
        enemyShot = new EnemyShot(enemyShotSpriteArray);

        enemy1SpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.spider1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.spider2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.spider3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.spider4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.spider5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.spider6, opts)};
        enemy1 = new Enemy1(enemy1SpriteArray);

        enemy2SpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.bat1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bat2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bat3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bat4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bat5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bat6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bat7, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bat8, opts)};
        enemy2 = new Enemy2(enemy2SpriteArray);

        enemy3SpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.torreta1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.torreta2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.torreta3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.torreta4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.torreta5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.torreta6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.torreta7, opts)};
        enemy3 = new Enemy3(enemy3SpriteArray);

        rockSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.roca1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.roca2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.roca3, opts)};
        rock = new Rock(rockSpriteArray);


        itemSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.blorx_eye1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.blorx_eye2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.blorx_eye3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.blorx_eye4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.blorx_eye5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.blorx_eye6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.baston1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.baston2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.baston3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.baston4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.baston5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.baston6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.burger1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.burger2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.burger3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.burger4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.burger5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.burger6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.orbe1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.orbe2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.orbe3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.orbe4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.orbe5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.orbe6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pipa1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pipa2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pipa3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pipa4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pipa5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pipa6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pocion1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pocion2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pocion3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pocion4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pocion5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.pocion6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.rama1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.rama2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.rama3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.rama4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.rama5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.rama6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.nike1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.nike2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.nike3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.nike4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.nike5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.nike6, opts)};
        item = new Item(itemSpriteArray);

        itemTextArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.blorgxeyetext, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.godsstafftext, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.crazyhamburgertext, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.drakanustext, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.ghettosglocktext, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.codeinenspritetext, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hardwoodbranchtext, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.agersdriptext, opts)};
        itemText = new ItemText(itemTextArray);

        doorSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.door1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.door2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.door3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.door4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.golddoor1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.golddoor2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.golddoor3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.golddoor4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bossroom1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bossroom2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bossroom3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.bossroom4, opts)};
        door = new Door(doorSpriteArray);

        pointsArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.cero, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.uno, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.dos, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.tres, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.cuatro, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.cinco, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.seis, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.siete, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.ocho, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.nueve, opts)};
        point = new Point(pointsArray);

        bossSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.boss1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.boss2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.boss3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.boss4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.boss5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.boss6, opts)};
        boss = new Boss(bossSpriteArray);

        holeSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.hole1, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole2, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole3, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole4, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole5, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole6, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole7, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole8, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole9, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole10, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole11, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.hole12, opts)};
        hole = new Hole(holeSpriteArray);

        mapSpriteArray = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.roominmap, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.notvisitedroominmap, opts),
                BitmapFactory.decodeResource(getResources(), R.drawable.activeroominmap, opts)};
        map = new Map(mapSpriteArray);

        shadow = new Shadow(BitmapFactory.decodeResource(getResources(), R.drawable.shadow, opts));
        playerCross = new PlayerCross(BitmapFactory.decodeResource(getResources(), R.drawable.crosstest, opts));
        shotCross = new ShotCross(BitmapFactory.decodeResource(getResources(), R.drawable.crosstestsimple, opts));
        mapButton = new MapButton(BitmapFactory.decodeResource(getResources(), R.drawable.mapbutton, opts));
        health = new Health(BitmapFactory.decodeResource(getResources(), R.drawable.heart, opts));
        dark = new Dark(BitmapFactory.decodeResource(getResources(), R.drawable.black, opts));
        paper = new Paper(BitmapFactory.decodeResource(getResources(), R.drawable.endpaper, opts));
        collision = new Collision();
        userDropdown = new UserDropdown(context);

        RunDate.getDate();
        RoomGen.generate();
        Map.seenrooms.clear();
        Map.generate();
        Point.points = 0;
        Point.kills = 0;
        Timer.seconds = 0;
        Paper.paper = 0;
        Dark.darken = 0;
        PlayerCross.enabled = 0;
        ShotCross.enabled = 0;
        thread.startLoop();
        timer.startTimer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    /**
     * Method called on every iteration of the MainThread,
     * handles all the changes on game variables
     */
    public void update() {
        collision.update();
        mapButton.update();
        playerCross.update();
        shotCross.update();
        if (PlayerShot.shots.size() > 0) {
            playerShot.update();
        }
        if (Enemy1.enemies1.size() > 0) {
            enemy1.update();
        }
        if (Enemy2.enemies2.size() > 0) {
            enemy2.update();
        }
        if (Enemy3.enemies3.size() > 0) {
            enemy3.update();
        }
        if (EnemyShot.shots.size() > 0) {
            enemyShot.update();
        }
        if (Boss.bosses.size() > 0) {
            boss.update();
        }
        itemText.update();
        if (Paper.paper == 1) {
            userDropdown.update();
        }
    }

    /**
     * Method called on every iteration of the MainThread,
     * handles all the changes graphic part of the game
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            background.draw(canvas);
            hole.draw(canvas);
            shadow.draw(canvas);

            if (EnemyShot.shots.size() > 0) {
                enemyShot.draw(canvas);
            }
            if (PlayerShot.shots.size() > 0) {
                playerShot.draw(canvas);
            }
            if (Rock.rocksx.size() > 0) {
                rock.draw(canvas);
            }
            door.draw(canvas);
            if (Enemy1.enemies1.size() > 0) {
                enemy1.draw(canvas);
            }
            if (Enemy3.enemies3.size() > 0) {
                enemy3.draw(canvas);
            }
            if (Item.items.size() > 0) {
                item.draw(canvas);
            }

            player.draw(canvas);
            if (Boss.bosses.size() > 0) {
                boss.draw(canvas);
            }
            if (Enemy2.enemies2.size() > 0) {
                enemy2.draw(canvas);
            }
            playerCross.draw(canvas);
            shotCross.draw(canvas);
            mapButton.draw(canvas);
            map.draw(canvas);
            itemText.draw(canvas);
            health.draw(canvas);
            if (Dark.darken == 1) {
                dark.draw(canvas);
            }
            if (Paper.paper == 1) {
                paper.draw(canvas);
            }
            point.draw(canvas);
            if (Paper.paper == 1) {
                userDropdown.draw(canvas);
            }
        }
    }

    public void pause() {
        thread.stopLoop();
    }

    public void timerpause() {
        timer.stopTimer();
    }
}
