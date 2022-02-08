package Connection;

import android.content.Context;
import android.os.AsyncTask;

import Activities.MainActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbPostgres extends AsyncTask<Context,Void,Void> {
    public static List<User> users = new ArrayList<>();


    @Override
    protected Void doInBackground(Context... context) {
        try {
            try {
                Class.forName("org.postgresql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.65.6/DisunityOfPepe", "openpg", "openpgpwd");
                //REVISAR ESTO (LOS CAMPOS)
                String sql = "Select id, name, job_title, work_phone, work_email from hr_employee ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                int index = 0;
                while (rs.next()) {
                    users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("job_title"), rs.getString("work_phone"), rs.getString("work_email")));
                    index++;
                }

            } catch (SQLException e) {
                System.err.println(e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        MainActivity.addUsers(users);

        return null;
    }
}
