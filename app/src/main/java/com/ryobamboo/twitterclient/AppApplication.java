package com.ryobamboo.twitterclient;

import android.app.Application;

import com.ryobamboo.twitterclient.cores.Injector;
import com.ryobamboo.twitterclient.modules.AppModule;
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
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static AppApplication getInstance() {
        return instance;
    }
}
