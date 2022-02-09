package Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.myapplication.R;

import Miscellaneous.Music;
import Miscellaneous.RunDate;

import java.util.List;

import Connection.DbPostgres;
import Connection.User;

public class MainActivity extends Activity {
    public static SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("Users", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(id int, name VARCHAR, jobTitle VARCHAR, workPhone VARCHAR, workEmail VARCHAR);");
        DbPostgres dbPostgres = new DbPostgres();
        dbPostgres.execute(this.getApplicationContext());
        RunDate.getDate();


        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GameActivity.class));
            }
        });
    }

    public static void addUsers(List<User> users){
        for(User u : users){
            String insert_query ="INSERT INTO Users VALUES ('" + u.getId() + "', '" + u.getName() + "', '" + u.getJobTitle() +"', '"+ u.getWorkPhone() + "', '"+u.getWorkEmail()+"')";
            db.execSQL(insert_query);
        }

    }
}