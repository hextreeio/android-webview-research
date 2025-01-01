package io.hextree.webviews;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private static final String PREFS_NAME = "prefs";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;


    public static void initialize(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        //Log.i("Prefs", key+" get "+sharedPreferences.getBoolean(key, defaultValue));
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void putBoolean(String key, boolean value) {
        if (sharedPreferences == null) {

            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        //Log.i("Prefs", key+" set "+value);
        editor.putBoolean(key, value);
        editor.apply();
    }
    public static int getInt(String key) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        //Log.i("Prefs", key+" get "+sharedPreferences.getBoolean(key, defaultValue));
        return sharedPreferences.getInt(key, -1);
    }

    public static void putInt(String key, int value) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        //Log.i("Prefs", key+" set "+value);
        editor.putInt(key, value);
        editor.apply();
    }
    public static String getString(String key) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        //Log.i("Prefs", key+" get "+sharedPreferences.getBoolean(key, defaultValue));
        return sharedPreferences.getString(key, null);
    }

    public static void putString(String key, String value) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        //Log.i("Prefs", key+" set "+value);
        editor.putString(key, value);
        editor.apply();
    }
}
