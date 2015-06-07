package com.themerrybunch.unlockmypc;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;

public class Amazon {

    private static AmazonSQSClient amazonSQSClient;

    public static AmazonSQSClient getAmazonSQSClientInstance(){
        if (amazonSQSClient != null)
            return amazonSQSClient;
        else
            throw new AssertionError("Cannot be null");
    }

    public static void initAmazonSQSClient(AWSConfig awsConfig){
        AWSCredentials credentials = new BasicAWSCredentials(awsConfig.getAccessKey(), awsConfig.getSecretKey());
        amazonSQSClient = new AmazonSQSClient(credentials);
        amazonSQSClient.setEndpoint(awsConfig.getEndpoint());
    }

}
