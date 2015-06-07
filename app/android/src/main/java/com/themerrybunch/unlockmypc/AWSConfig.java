package com.themerrybunch.unlockmypc;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;

public class AWSConfig {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    public String getEndpoint(){
        return this.endpoint;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public static AWSConfig fromReader(Reader reader) throws IOException {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).create().fromJson(reader, AWSConfig.class);
    }
}
