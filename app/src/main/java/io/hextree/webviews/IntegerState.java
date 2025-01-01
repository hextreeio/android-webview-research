package io.hextree.webviews;

import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerState {

    // AtomicInteger to ensure thread-safe operations
    private static final AtomicInteger state = new AtomicInteger(0);

    // Private constructor to prevent instantiation
    private IntegerState() {}

    /**
     * Get the current value of the state.
     * @return The current integer value.
     */
    public static int getValue() {
        return state.get();
    }

    public static void waitForState(int i) {

        try {
            while(state.get() < i) {
                Log.i("PWN", "wait for state: "+state.get()+" < "+i);
                Thread.sleep(1000);
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Set a new value for the state.
     * @param value The new integer value to set.
     */
    public static void setValue(int value) {
        state.set(value);
    }
}
