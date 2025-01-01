package io.hextree.webviews.customtabs;

import static androidx.annotation.Dimension.PX;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.ExperimentalMinimizationCallback;

import io.hextree.webviews.Utils;

public class AttackerTabsCallback extends CustomTabsCallback {


    CustomTabsCallback app_callback;

    public AttackerTabsCallback(CustomTabsCallback _callback) {
        app_callback = _callback;
    }

    String TAG = "AttackerTabsCallback";
    public void onNavigationEvent(int navigationEvent, @Nullable Bundle extras) {
        Log.i(TAG, "onNavigationEvent("+navigationEvent+", "+ Utils.dumpBundle(extras)+")");
        app_callback.onNavigationEvent(navigationEvent, extras);
    }

    public void extraCallback(@NonNull String callbackName, @Nullable Bundle args) {
        Log.i(TAG, "extraCallback("+callbackName+", "+ Utils.dumpBundle(args)+")");
        app_callback.extraCallback(callbackName, args);
    }

    @Nullable
    public Bundle extraCallbackWithResult(@NonNull String callbackName, @Nullable Bundle args) {
        Log.i(TAG, "extraCallbackWithResult("+callbackName+", "+ Utils.dumpBundle(args)+")");
        return app_callback.extraCallbackWithResult(callbackName, args);
    }

    public void onMessageChannelReady(@Nullable Bundle extras) {
        Log.i(TAG, "onMessageChannelReady("+ extras +")");
        app_callback.onMessageChannelReady(extras);
    }

    public void onPostMessage(@NonNull String message, @Nullable Bundle extras) {
        Log.i(TAG, "onPostMessage("+message+", "+ Utils.dumpBundle(extras)+")");
        app_callback.onPostMessage(message, extras);
    }

    public void onRelationshipValidationResult(@CustomTabsService.Relation int relation, @NonNull Uri requestedOrigin,
                                               boolean result, @Nullable Bundle extras) {
        Log.i(TAG, "onRelationshipValidationResult("+relation+", "+requestedOrigin.toString()+", "+result+", "+ Utils.dumpBundle(extras)+")");
        app_callback.onRelationshipValidationResult(relation, requestedOrigin, result, extras);
    }

    public void onActivityResized(@Dimension(unit = PX) int height,
                                  @Dimension(unit = PX) int width, @NonNull Bundle extras) {
        Log.i(TAG, "onActivityResized("+height+", "+width+", "+ Utils.dumpBundle(extras)+")");
        app_callback.onActivityResized(height, width, extras);
    }

    public void onWarmupCompleted(@NonNull Bundle extras) {
        Log.i(TAG, "onWarmupCompleted("+ Utils.dumpBundle(extras)+")");
        app_callback.onWarmupCompleted(extras);
    }

    public void onActivityLayout(@Dimension(unit = PX) int left, @Dimension(unit = PX) int top,
                                 @Dimension(unit = PX) int right, @Dimension(unit = PX) int bottom,
                                 @CustomTabsCallback.ActivityLayoutState int state, @NonNull Bundle extras) {
        Log.i(TAG, "onActivityResized("+left+", "+top+", "+right+", "+bottom+", "+state+", "+ Utils.dumpBundle(extras)+")");
        app_callback.onActivityLayout(left, top, right, bottom, state, extras);
    }

    @ExperimentalMinimizationCallback
    public void onMinimized(@NonNull Bundle extras) {
        Log.i(TAG, "onMinimized("+ Utils.dumpBundle(extras)+")");
        app_callback.onMinimized(extras);
    }

    @ExperimentalMinimizationCallback
    public void onUnminimized(@NonNull Bundle extras) {
        Log.i(TAG, "onUnminimized("+ Utils.dumpBundle(extras)+")");
        app_callback.onUnminimized(extras);
    }

}
