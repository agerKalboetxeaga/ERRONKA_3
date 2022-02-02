package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.User;


public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private List<User> users = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        users = getUsers();
        db = openOrCreateDatabase("Users", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(id, int, name VARCHAR, jobTitle VARCHAR, workPhone VARCHAR, workEmail, VARCHAR);");
        addUsers();
    }

    public List<User> getUsers() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    try{
                        Class.forName("org.postgresql.Driver");

                        Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.65.6:5432/DisunityOfPepe", "openpg", "openpgpwd");
                        //Connection conn = DriverManager.getConnection(url, "openpg", "openpgpwd");
                        //REVISAR ESTO (LOS CAMPOS)
                        String sql = "Select id, name, job_title, work_phone, work_email from hr_employee ";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery();
                        while (rs.next()) {
                            users.add(new User(rs.getInt("id"), rs.getString("name"),rs.getString("job_title"),rs.getString("work_phone"),rs.getString("work_email")));
                        }

                    }catch(SQLException e){
                        System.err.println(e);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.run();


        return users;
    }

    public void addUsers(){
      for(User u : users){
          String insert_query ="INSERT INTO Users VALUES ('" + u.getId() + "', '" + u.getName() + "', '" + u.getJobTitle() +"', '"+ u.getWorkPhone() + "', '"+u.getWorkEmail()+"')";
          db.execSQL(insert_query);
          // si esto peta mira este tuto https://stackoverflow.com/questions/5703330/saving-arraylists-in-sqlite-databases
      }

    }
}