package com.ryobamboo.twitterclient;

import android.app.Application;

import com.ryobamboo.twitterclient.cores.Injector;
import com.ryobamboo.twitterclient.modules.AppModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;
//import com.ryobamboo.twitterclient.modules.RootModule;

public class AppApplication extends Application {

    private static AppApplication instance;

    public AppApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.init(new AppModule(), this);

        // Fabricの認証
        TwitterAuthConfig authConfig = new TwitterAuthConfig(getString(R.string.twitter_key), getString(R.string.twitter_secret));
        Fabric.with(this, new Twitter(authConfig));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static AppApplication getInstance() {
        return instance;
    }
}
