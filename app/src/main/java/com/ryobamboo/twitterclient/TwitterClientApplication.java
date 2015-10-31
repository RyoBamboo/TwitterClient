package com.ryobamboo.twitterclient;

import android.app.Application;

public class TwitterClientApplication extends Application {

    private static TwitterClientApplication instance;

    public TwitterClientApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static TwitterClientApplication getInstance() {
        return instance;
    }
}
