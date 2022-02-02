package db;

import android.provider.BaseColumns;

public class UserContract {
    private UserContract() {}

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "Users";

        public static final String Column_ID = "id";
        public static final String Column_NAME = "name";
        public static final String Column_Name="";
    }
}
