package com.ryobamboo.twitterclient.modules;

import android.content.Context;

import com.ryobamboo.twitterclient.AppApplication;
import com.ryobamboo.twitterclient.activities.MainActivity;
import com.ryobamboo.twitterclient.cores.AppAuthenticator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        complete = false,
        library = true,
        injects = {
                AppApplication.class,
                MainActivity.class
        }
)


public class AppModule {

        @Provides
        @Singleton
        Context provideApplicationContext() {
            return AppApplication.getInstance().getApplicationContext();
        }

        @Provides
        AppApplication provideAppApplication() {
            return AppApplication.getInstance();
        }

        @Singleton
        @Provides
        AppAuthenticator provideAppAuthenticator(Context context) {
                return new AppAuthenticator(context);
        }
}
