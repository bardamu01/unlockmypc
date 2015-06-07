package com.themerrybunch.unlockmypc;

import android.os.AsyncTask;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class AmazonSQSSendMessageTask extends AsyncTask<SendMessageRequest, Void, Void>{

    private Exception exception;

    @Override
    protected Void doInBackground(SendMessageRequest... params) {
        try {
            Amazon.getAmazonSQSClientInstance().sendMessage(params[0]);
        }catch (Exception e){
            throw e;
        }
        return null;
    }
}
