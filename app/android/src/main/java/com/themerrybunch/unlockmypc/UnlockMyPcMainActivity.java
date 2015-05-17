package com.themerrybunch.unlockmypc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class UnlockMyPcMainActivity extends Activity {

    public static final String TAG = "UnlockMyPc";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "++ ON CREATE ++");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "++ ON START ++");
    }

    @Override
    public synchronized void onResume() {
        super.onResume();
        Log.d(TAG, "+ ON RESUME +");
    }

    @Override
    public synchronized void onPause() {
        super.onPause();
        Log.d(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "--- ON DESTROY ---");
    }
}
