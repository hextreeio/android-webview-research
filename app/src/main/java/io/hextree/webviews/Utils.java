package io.hextree.webviews;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

public class Utils {
    public static void copyFileFromAssetToInternal(Context context, String fname) {
        // copy `fname` from `./assets/` folder to the app internal `./files/` folder
        try {
            InputStream inputStream = null;
            inputStream = context.getAssets().open(fname);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line+"\n");
            }
            reader.close();

            File fileIndex = new File(context.getFilesDir(), fname);
            FileOutputStream fos = new FileOutputStream(fileIndex);
            fos.write(builder.toString().getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readAssetFile(Context context, String fname) {
        try {
            InputStream inputStream = null;
            inputStream = context.getAssets().open(fname);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
            reader.close();
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFileFromAssetToInternal(Context context, String fname, String target_fname) {
        // copy `fname` from `./assets/` folder to the app internal `./files/` folder
        try {
            InputStream inputStream = null;
            inputStream = context.getAssets().open(fname);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line+"\n");
            }
            reader.close();

            File fileIndex = new File(context.getFilesDir(), target_fname);
            FileOutputStream fos = new FileOutputStream(fileIndex);
            fos.write(builder.toString().getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteFileFromInternal(Context context, String fname) {
        // Delete `fname` from the app internal `./files/` folder
        File file = new File(context.getFilesDir(), fname);
        if (file.exists()) {
            return file.delete();
        }
        return false; // File does not exist
    }

    public static String dumpIntent(Context context, Intent intent) {
        return dumpIntent(context, intent, 0);
    }

    private static String dumpIntent(Context context, Intent intent, int indentLevel) {
        if (intent == null) {
            return "Intent is null";
        }

        StringBuilder sb = new StringBuilder();
        String indent = new String(new char[indentLevel]).replace("\0", "    ");

        // Append basic intent information
        sb.append(indent).append("[Action]    ").append(intent.getAction()).append("\n");
        // Append categories
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            for (String category : categories) {
                sb.append(indent).append("[Category]  ").append(category).append("\n");
            }
        }
        sb.append(indent).append("[Data]      ").append(intent.getDataString()).append("\n");
        sb.append(indent).append("[Component] ").append(intent.getComponent()).append("\n");
        sb.append(indent).append("[Flags]     ").append(getFlagsString(intent.getFlags())).append("\n");

        // Append extras
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                Object value = extras.get(key);
                if (value instanceof Intent) {
                    sb.append(indent).append("[Extra:'").append(key).append("'] -> Intent\n");
                    sb.append(dumpIntent(context, (Intent) value, indentLevel + 1));  // Recursively dump nested intents with increased indentation
                } else if (value instanceof Bundle) {
                    sb.append(indent).append("[Extra:'").append(key).append("'] -> Bundle\n");
                    sb.append(dumpBundle((Bundle) value, indentLevel + 1));  // Recursively dump nested intents with increased indentation
                } else if(value instanceof PendingIntent) {
                    sb.append(indent).append("[Extra:'").append(key).append("'] -> ").append(value.toString()).append("\n");
                    sb.append(indent).append("[getCreatorPackage:'").append(((PendingIntent) value).getCreatorPackage()).append("']\n");
                } else {
                    sb.append(indent).append("[Extra:'").append(key).append("']: ").append(value).append("\n");
                }
            }
        }

        // Query the content URI if FLAG_GRANT_READ_URI_PERMISSION is set
        /*
        if ((intent.getFlags() & Intent.FLAG_GRANT_READ_URI_PERMISSION) != 0) {
            Uri data = intent.getData();
            if (data != null) {
                sb.append(queryContentUri(context, data, indentLevel + 1));
            }
        }
        */

        return sb.toString();
    }

    private static String getFlagsString(int flags) {
        StringBuilder flagBuilder = new StringBuilder();
        if ((flags & Intent.FLAG_GRANT_READ_URI_PERMISSION) != 0) flagBuilder.append("GRANT_READ_URI_PERMISSION | ");
        if ((flags & Intent.FLAG_GRANT_WRITE_URI_PERMISSION) != 0) flagBuilder.append("GRANT_WRITE_URI_PERMISSION | ");
        if ((flags & Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION) != 0) flagBuilder.append("GRANT_PERSISTABLE_URI_PERMISSION | ");
        if ((flags & Intent.FLAG_GRANT_PREFIX_URI_PERMISSION) != 0) flagBuilder.append("GRANT_PREFIX_URI_PERMISSION | ");
        if ((flags & Intent.FLAG_ACTIVITY_NEW_TASK) != 0) flagBuilder.append("ACTIVITY_NEW_TASK | ");
        if ((flags & Intent.FLAG_ACTIVITY_SINGLE_TOP) != 0) flagBuilder.append("ACTIVITY_SINGLE_TOP | ");
        if ((flags & Intent.FLAG_ACTIVITY_NO_HISTORY) != 0) flagBuilder.append("ACTIVITY_NO_HISTORY | ");
        if ((flags & Intent.FLAG_ACTIVITY_CLEAR_TOP) != 0) flagBuilder.append("ACTIVITY_CLEAR_TOP | ");
        if ((flags & Intent.FLAG_ACTIVITY_FORWARD_RESULT) != 0) flagBuilder.append("ACTIVITY_FORWARD_RESULT | ");
        if ((flags & Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP) != 0) flagBuilder.append("ACTIVITY_PREVIOUS_IS_TOP | ");
        if ((flags & Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS) != 0) flagBuilder.append("ACTIVITY_EXCLUDE_FROM_RECENTS | ");
        if ((flags & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) flagBuilder.append("ACTIVITY_BROUGHT_TO_FRONT | ");
        if ((flags & Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED) != 0) flagBuilder.append("ACTIVITY_RESET_TASK_IF_NEEDED | ");
        if ((flags & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) != 0) flagBuilder.append("ACTIVITY_LAUNCHED_FROM_HISTORY | ");
        if ((flags & Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET) != 0) flagBuilder.append("ACTIVITY_CLEAR_WHEN_TASK_RESET | ");
        if ((flags & Intent.FLAG_ACTIVITY_NEW_DOCUMENT) != 0) flagBuilder.append("ACTIVITY_NEW_DOCUMENT | ");
        if ((flags & Intent.FLAG_ACTIVITY_NO_USER_ACTION) != 0) flagBuilder.append("ACTIVITY_NO_USER_ACTION | ");
        if ((flags & Intent.FLAG_ACTIVITY_REORDER_TO_FRONT) != 0) flagBuilder.append("ACTIVITY_REORDER_TO_FRONT | ");
        if ((flags & Intent.FLAG_ACTIVITY_NO_ANIMATION) != 0) flagBuilder.append("ACTIVITY_NO_ANIMATION | ");
        if ((flags & Intent.FLAG_ACTIVITY_CLEAR_TASK) != 0) flagBuilder.append("ACTIVITY_CLEAR_TASK | ");
        if ((flags & Intent.FLAG_ACTIVITY_TASK_ON_HOME) != 0) flagBuilder.append("ACTIVITY_TASK_ON_HOME | ");
        if ((flags & Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS) != 0) flagBuilder.append("ACTIVITY_RETAIN_IN_RECENTS | ");
        if ((flags & Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT) != 0) flagBuilder.append("ACTIVITY_LAUNCH_ADJACENT | ");
        if ((flags & Intent.FLAG_ACTIVITY_REQUIRE_DEFAULT) != 0) flagBuilder.append("ACTIVITY_REQUIRE_DEFAULT | ");
        if ((flags & Intent.FLAG_ACTIVITY_REQUIRE_NON_BROWSER) != 0) flagBuilder.append("ACTIVITY_REQUIRE_NON_BROWSER | ");
        if ((flags & Intent.FLAG_ACTIVITY_MATCH_EXTERNAL) != 0) flagBuilder.append("ACTIVITY_MATCH_EXTERNAL | ");
        if ((flags & Intent.FLAG_ACTIVITY_MULTIPLE_TASK) != 0) flagBuilder.append("ACTIVITY_MULTIPLE_TASK | ");
        if ((flags & Intent.FLAG_RECEIVER_REGISTERED_ONLY) != 0) flagBuilder.append("RECEIVER_REGISTERED_ONLY | ");
        if ((flags & Intent.FLAG_RECEIVER_REPLACE_PENDING) != 0) flagBuilder.append("RECEIVER_REPLACE_PENDING | ");
        if ((flags & Intent.FLAG_RECEIVER_FOREGROUND) != 0) flagBuilder.append("RECEIVER_FOREGROUND | ");
        if ((flags & Intent.FLAG_RECEIVER_NO_ABORT) != 0) flagBuilder.append("RECEIVER_NO_ABORT | ");
        if ((flags & Intent.FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS) != 0) flagBuilder.append("RECEIVER_VISIBLE_TO_INSTANT_APPS | ");

        if (flagBuilder.length() > 0) {
            // Remove the trailing " | "
            flagBuilder.setLength(flagBuilder.length() - 3);
        }

        return flagBuilder.toString();
    }

    public static String dumpBundle(Bundle bundle) {
        return dumpBundle(bundle, 0);
    }

    private static String dumpBundle(Bundle bundle, int indentLevel) {
        if (bundle == null) {
            return "Bundle is null";
        }

        StringBuilder sb = new StringBuilder();
        String indent = new String(new char[indentLevel]).replace("\0", "    ");

        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (value instanceof Bundle) {
                sb.append(String.format("%s['%s']: Bundle[\n%s%s]\n", indent, key, dumpBundle((Bundle) value, indentLevel + 1), indent));
            } else {
                sb.append(String.format("%s['%s']: %s\n", indent, key, value != null ? value.toString() : "null"));
            }
        }
        return sb.toString();
    }

    public static void showDialog(Context context, Intent intent) {
        if(intent == null) return;
        // Create the dialog
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);

        // Create a LinearLayout to hold the dialog content
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 50, 20, 50);
        layout.setBackgroundColor(0xffefeff5);


        // Add a TextView for the title
        TextView title = new TextView(context);
        title.setText("Intent Details: ");
        title.setTextSize(16);
        title.setTextColor(0xff000000);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setPadding(0, 0, 0, 40);
        title.setGravity(Gravity.CENTER);
        title.setBackgroundColor(0xffefeff5);
        layout.addView(title);

        // Add a TextView for the message
        TextView message = new TextView(context);
        message.setText(dumpIntent(context, intent));
        message.setTypeface(Typeface.MONOSPACE);
        message.setTextSize(12);
        message.setTextColor(0xff000000);
        message.setPadding(0, 0, 0, 30);
        message.setGravity(Gravity.START);
        message.setBackgroundColor(0xffefeff5);
        layout.addView(message);

        // Add an OK button
        Button positiveButton = new Button(context);
        positiveButton.setText("OK");
        positiveButton.setTextColor(0xff000000);
        positiveButton.setOnClickListener(v -> dialog.dismiss());
        layout.addView(positiveButton);

        // Set the layout as the content view of the dialog
        dialog.setContentView(layout);

        // Adjust dialog window parameters to make it fullscreen
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams wlp = window.getAttributes();
            wlp.gravity = Gravity.BOTTOM;
            wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(wlp);
        }

        dialog.show();
        // Animate the dialog with a slide-in effect
        layout.setTranslationY(2000); // Start off-screen to the right
        layout.setAlpha(0f);
        ObjectAnimator translateYAnimator = ObjectAnimator.ofFloat(layout, "translationY", 0);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(layout, "alpha", 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateYAnimator, alphaAnimator);
        animatorSet.setDuration(300); // Duration of the animation
        animatorSet.setStartDelay(100); // Delay before starting the animation
        animatorSet.start();
    }


    public static void dumpFile(Context context, Uri contentUri) {

        Log.d("File", "--------------------------------");
        Log.d("File", "Dumping "+contentUri.toString());
        try (InputStream inputStream = context.getContentResolver().openInputStream(contentUri)) {
            // Read the file content here
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                Log.d("File", " [*] " + line);
            }
        } catch (IOException e) {
            Log.d("File", " [!] IOException");
        } catch (SecurityException e) {
            Log.d("File", " [!] SecurityException");
        }
        Log.d("File", "--------------------------------");
    }

    public static void dumpTable(Context context, Uri contentUri) {

        Cursor cursor = context.getContentResolver().query(contentUri,
                null, null,
                null, null);

        Log.d("Table", "--------------------------------");
        Log.i("Table", "cursor: "+cursor);
        Log.i("Table", "cursor.getColumnCount: "+cursor.getColumnCount());
        Log.i("Table", "cursor.getCount: "+cursor.getCount());
        if (cursor!=null && cursor.moveToFirst()) {
            Log.i("Table", "dump columns");
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                }
                Log.d("Table", sb.toString());
            } while (cursor.moveToNext());
        }
        Log.d("Table", "--------------------------------");
    }
}
