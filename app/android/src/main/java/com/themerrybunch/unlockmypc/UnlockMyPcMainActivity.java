package com.themerrybunch.unlockmypc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.io.IOException;
import java.io.InputStreamReader;


public class UnlockMyPcMainActivity extends Activity {

    public static final String TAG = "UnlockMyPc";

    final static String AMAZON_SQS_FILE = "amazon-sqs.json";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "++ ON CREATE ++");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "++ ON START ++");

        AWSConfig awsConfig;
        try {
            awsConfig = AWSConfig.fromReader(new InputStreamReader(this.getAssets().open(AMAZON_SQS_FILE)));
        } catch (IOException e) {
            throw new AssertionError("Failed to load AWS config");
        }
        Log.d(TAG, "Loaded AWS config");
        Amazon.initAmazonSQSClient(awsConfig);
        Log.d(TAG, "Configured AWS client");

        SendMessageRequest msg = new SendMessageRequest();
        msg.setMessageBody("test");
        new AmazonSQSSendMessageTask().execute(msg);
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
