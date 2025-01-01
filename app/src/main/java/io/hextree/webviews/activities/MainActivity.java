package io.hextree.webviews.activities;

import android.app.PendingIntent;
import android.app.role.RoleManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.provider.Settings;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

import io.hextree.webviews.DatabaseHelper;
import io.hextree.webviews.IntegerState;
import io.hextree.webviews.PreferenceHelper;
import io.hextree.webviews.R;
import io.hextree.webviews.Utils;

public class MainActivity extends AppCompatActivity {

    public DatabaseHelper db;
    public PreferenceHelper prefs;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("Hextree", "onActivityResult("+requestCode+", "+Utils.dumpIntent(this, data)+")");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        PreferenceHelper.initialize(this);
        PreferenceHelper.putString("secret","secret-test-shared_prefs-file");

        Utils.copyFileFromAssetToInternal(getApplicationContext(), "secret.html");
        Utils.copyFileFromAssetToInternal(getApplicationContext(), "secret.xml");
        Utils.copyFileFromAssetToInternal(getApplicationContext(), "origins.html");
        Utils.copyFileFromAssetToInternal(getApplicationContext(), "files.html");
        Utils.copyFileFromAssetToInternal(getApplicationContext(), "storage.html");
        Utils.copyFileFromAssetToInternal(getApplicationContext(), "pwn.html");

        db = new DatabaseHelper(this);
        db.getReadableDatabase();
        Log.i("DB", "db object: "+db);


        //Intent t = new Intent(this, WebViewOriginTestActivity.class);
        ((Button) findViewById(R.id.btn_files)).setOnClickListener(view -> {
            Intent t = new Intent(this, WebViewsTestActivity.class);
            t.putExtra("TEST_CASE", "files.html");
            startActivity(t);
        });

        ((Button) findViewById(R.id.btn_origin)).setOnClickListener(view -> {
            Intent t = new Intent(this, WebViewsTestActivity.class);
            t.putExtra("TEST_CASE", "origins.html");
            startActivity(t);
        });

        ((Button) findViewById(R.id.btn_storage)).setOnClickListener(view -> {
            Intent t = new Intent(this, WebViewsTestActivity.class);
            t.putExtra("TEST_CASE", "storage.html");
            startActivity(t);
        });

        ((Button) findViewById(R.id.btn_pwn)).setOnClickListener(view -> {
            Intent t = new Intent(this, WebViewsTestActivity.class);
            t.putExtra("TEST_CASE", "pwn.html");
            startActivity(t);
        });

        ((Button) findViewById(R.id.btn_jsinterface)).setOnClickListener(view -> {
            Intent t = new Intent(this, WebViewsJavaScriptActivity.class);
            startActivity(t);
        });

        ((Button) findViewById(R.id.btn_customtab)).setOnClickListener(view -> {
            Intent t = new Intent(this, CustomTabsActivity.class);
            startActivity(t);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}