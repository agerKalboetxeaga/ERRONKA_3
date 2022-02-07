package Miscellaneous;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RunDate {
    public static String getDate(){
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }
}
