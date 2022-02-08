package Connection;

import android.util.Log;

import Miscellaneous.GameView;
import Miscellaneous.Point;
import Miscellaneous.RunDate;
import Miscellaneous.Timer;
import Sprites.UserDropdown;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JSONcreator {
    public static File jsonfile;
    public static void createJSON() {

        JSONObject json = new JSONObject();
        JSONObject langilea_Item = new JSONObject();

        try {
            langilea_Item.put("id", String.valueOf(UserDropdown.users.get(UserDropdown.selection).getId()));
            langilea_Item.put("name", UserDropdown.users.get(UserDropdown.selection).getName());
            langilea_Item.put("jobTitle", UserDropdown.users.get(UserDropdown.selection).getJobTitle());
            langilea_Item.put("workPhone", UserDropdown.users.get(UserDropdown.selection).getWorkPhone());
            langilea_Item.put("workEmail", UserDropdown.users.get(UserDropdown.selection).getWorkEmail());

            json.put("puntuazioa", String.valueOf(Point.points));
            json.put("kills", String.valueOf(Point.kills));
            json.put("time", String.valueOf(Timer.seconds));
            json.put("date", RunDate.getDate());
            Log.d("TAG", RunDate.getDate());
            json.put("employee", langilea_Item);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Printing the contents of the JSONObject to a JSON file
        PrintWriter printWriter = null;
        try {
            String fileName= "OutputInJSON.json";
            printWriter = new PrintWriter(GameView.path + fileName);
            jsonfile = new File(GameView.path + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        printWriter.write(json.toString());
        printWriter.flush();
        printWriter.close();
        System.out.println("Json File created successfully");
    }
}
