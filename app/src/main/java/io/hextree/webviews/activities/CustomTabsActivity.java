package io.hextree.webviews.activities;

import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.content.FileProvider;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import io.hextree.webviews.R;
import io.hextree.webviews.Utils;

public class CustomTabsActivity extends AppCompatActivity {

    CustomTabsSession session;
    boolean validated = false;

    final String TAG = "CustomTabs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customtab);

        try {
            bindCustomTabsServiceConnection();
        } catch (IllegalArgumentException e) {
            Log.i(TAG, "The app probably runs on an Android system without a compatible browser like Chrome. Is this a non-PlayStore emulator?");
            Toast.makeText(this, "No CustomTabs browser available?", Toast.LENGTH_LONG).show();
            finish();
        }

        findViewById(R.id.hextree_logo).setOnClickListener(view -> {
            if (session != null) {
                session.postMessage("Hello from Android!", null);
            }
        });

        findViewById(R.id.btn_defaultbrowser).setOnClickListener(view -> {

            RoleManager roleManager = (RoleManager) getSystemService(ROLE_SERVICE);
            Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_BROWSER);
            startActivityForResult(intent, 123);
        });

        // waiting for domain verification to pass
        findViewById(R.id.btn_open_trusted_cct).setEnabled(false);
        findViewById(R.id.btn_open_trusted_cct).setOnClickListener(view -> {
            String url = "https://oak.hackstree.io/android/webview/pwn.html";
            CustomTabColorSchemeParams params = new CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(Color.BLACK)
                    .build();

            CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder(session)
                    //.setInitialActivityHeightPx(getResources().getDisplayMetrics().heightPixels / 2)
                    .setColorSchemeParams(CustomTabsIntent.COLOR_SCHEME_DARK, params)
                    .setUrlBarHidingEnabled(true)
                    .build();

            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            //customTabsIntent.intent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);

            Bundle headers = new Bundle();
            headers.putString("bearer-token", "Some other header");
            headers.putString("Content-Type", "text/plain");
            headers.putString("Authorization", "Bearer test");

            customTabsIntent.intent.putExtra(Browser.EXTRA_HEADERS, headers);

            customTabsIntent.launchUrl(this, Uri.parse(url));
        });

        findViewById(R.id.btn_opencct_session).setEnabled(false);
        findViewById(R.id.btn_opencct_session).setOnClickListener(view -> {
            String url = "https://ht-api-mocks-902809310725.us-central1.run.app/android/webview/pwn.html";
            CustomTabColorSchemeParams params = new CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(Color.BLACK)
                    .build();

            CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder(session)
                    .setInitialActivityHeightPx(getResources().getDisplayMetrics().heightPixels / 2)
                    .setColorSchemeParams(CustomTabsIntent.COLOR_SCHEME_DARK, params)
                    .setUrlBarHidingEnabled(false)
                    .build();

            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

            Bundle headers = new Bundle();
            headers.putString("bearer-token", "Some other header");
            headers.putString("Content-Type", "text/plain");
            headers.putString("Authorization", "Bearer test");

            customTabsIntent.intent.putExtra(Browser.EXTRA_HEADERS, headers);

            customTabsIntent.launchUrl(this, Uri.parse(url));
        });

        findViewById(R.id.btn_opencct).setOnClickListener(view -> {
            String url = "https://oak.hackstree.io/android/webview/pwn.html";
            CustomTabColorSchemeParams params = new CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(Color.BLACK)
                    .build();

            CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder(null)
                    .setInitialActivityHeightPx(getResources().getDisplayMetrics().heightPixels / 2)
                    .setColorSchemeParams(CustomTabsIntent.COLOR_SCHEME_DARK, params)
                    .setUrlBarHidingEnabled(true)
                    .build();

            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            customTabsIntent.intent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", false);

            customTabsIntent.launchUrl(this, Uri.parse(url));
        });

    }

    @NonNull
    private void bindCustomTabsServiceConnection() {
        CustomTabsCallback callback = new CustomTabsCallback() {

            @Override
            public void onNavigationEvent(int navigationEvent, @Nullable Bundle extras) {
                Log.i(TAG, "onNavigationEvent("+navigationEvent+", \""+Utils.dumpBundle(extras).replace("\n","")+"\")");
                if(navigationEvent == 6) {
                }
                if (navigationEvent != NAVIGATION_FINISHED) {
                    return;
                }
                if(session!=null && validated) {
                    boolean ret = session.requestPostMessageChannel(Uri.parse("https://oak.hackstree.io/"));
                    Log.i(TAG, "requestPostMessageChannel = "+ret);
                }
            }

            @Override
            public void onRelationshipValidationResult(int relation, @NonNull Uri requestedOrigin,
                                                       boolean result, @Nullable Bundle extras) {
                // Can launch custom tabs intent after session was validated as the same origin.
                Log.i(TAG, "onRelationshipValidationResult("+result+", \""+requestedOrigin.toString()+"\")");
                findViewById(R.id.btn_open_trusted_cct).setEnabled(true);
                findViewById(R.id.btn_opencct_session).setEnabled(true);
                validated = result;
            }

            @Override
            public void onMessageChannelReady(@NonNull Bundle extras) {
                Log.i(TAG, "onMessageChannelReady("+Utils.dumpBundle(extras).replace("\n", "")+")");
                // The channel is now ready, you can post messages to the page.
                if (session != null) {
                    session.postMessage("Hello from Android!", null);
                }
            }

            @Override
            public void onPostMessage(@NonNull String message, @NonNull Bundle extras) {
                Log.i(TAG, "onPostMessage(" + message + ", "+Utils.dumpBundle(extras).replace("\n", "")+")");
                if (session != null) session.postMessage("ACK: "+message, null);
            }
        };

        CustomTabsServiceConnection mConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(@NonNull ComponentName name,
                                                     @NonNull CustomTabsClient client) {
                // Create session after service connected.
                client.warmup(0);
                Log.i(TAG, "onCustomTabsServiceConnected("+name+", "+client+") "+Utils.dumpBundle(client.extraCommand("getAccountName", null)));
                // Validate the session as the same origin to allow cross origin headers.
                session = client.newSession(callback);
                if(!validated && session!=null) {
                    session.validateRelationship(CustomTabsService.RELATION_USE_AS_ORIGIN,
                            Uri.parse("https://oak.hackstree.io/"), null);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                session = null;
                finish();
            }
        };

        List<String> packageNames = Arrays.asList(
                "com.google.android.apps.chrome",
                "com.chrome.canary",
                "com.chrome.dev",
                "com.chrome.beta",
                "com.android.chrome"
        );
        String packageName = CustomTabsClient.getPackageName(getApplicationContext(), packageNames, false);
        Log.i(TAG, "Custom Tabs package: "+packageName);
        CustomTabsClient.bindCustomTabsService(this, packageName, mConnection);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // checking if we are default browser app
        if(resultCode == RESULT_OK) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS);
            startActivity(intent);
        }
    }

}