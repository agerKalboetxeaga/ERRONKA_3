package Sprites;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import androidx.core.content.res.ResourcesCompat;

import Activities.GameActivity;
import Miscellaneous.GameView;
import Activities.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

import Connection.User;

/**
 * Draws the users form the sqlite database, using a specified font
 */
public class UserDropdown {
    public static ArrayList<User> users = new ArrayList<>();
    public static int selection;
    public static double iter,buttonready,timebetween;
    Paint paint = new Paint();

    @SuppressLint("Range")
    public UserDropdown(Context context){
        Cursor c = MainActivity.db.rawQuery("SELECT * FROM Users", null);

        while(c.moveToNext()){
            users.add(new User (c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("name")),c.getString(c.getColumnIndex("jobTitle")),c.getString(c.getColumnIndex("workPhone")),c.getString(c.getColumnIndex("workEmail"))));
        }

        Log.d("TAG", "UsersSqliteDropdown: " + users.toString());
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.minecraft));
        paint.setTextSize(25);
        timebetween = 10;

    }

    public void draw(Canvas canvas) {
        canvas.drawText(users.get(selection).getName(),(int)(GameActivity.width/2.05),(int)(GameActivity.height/1.9),paint);
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
            if ((GameView.x0 >= GameActivity.width/2 - GameActivity.width* 0.1 && GameView.x0 <= GameActivity.width/2 + GameActivity.width* 0.1 && GameView.y0 >=  GameActivity.height/2 - GameActivity.height * 0.05 && GameView.y0 <= GameActivity.height/2 + GameActivity.height* 0.05)){
                selection++;
                GameView.x0 = 0;
                GameView.y0 = 0;
                buttonready = 0;
            }
        }
    }
}
