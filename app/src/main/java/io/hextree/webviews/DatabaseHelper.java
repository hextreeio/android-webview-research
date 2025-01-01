package io.hextree.webviews;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "internal.db";
    private static final int DATABASE_VERSION = 1;

    // Table Name
    public static final String TABLE_SECRET = "Secrets";

    // Column Names
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SECRET = "secret";


    private static final String CREATE_TABLE_SECRET =
            "CREATE TABLE " + TABLE_SECRET + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_SECRET + " TEXT NOT NULL );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("FlagDatabaseHelper", "database created");

        db.execSQL(CREATE_TABLE_SECRET);
        // Insert initial data
        db.execSQL("INSERT INTO " + TABLE_SECRET + " (" + COLUMN_NAME + ", " + COLUMN_SECRET +") VALUES ('auth', 'this-is-authkey');");
        db.execSQL("INSERT INTO " + TABLE_SECRET + " (" + COLUMN_NAME + ", " + COLUMN_SECRET +") VALUES ('key', 'abh92yuadvuy29bhsapidbh2u9');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SECRET);
        onCreate(db);
    }
}
