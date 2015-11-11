package com.ryobamboo.twitterclient.activities;

import android.app.Activity;
import android.os.Bundle;

import com.ryobamboo.twitterclient.R;
import com.ryobamboo.twitterclient.cores.AppAuthenticator;
import com.ryobamboo.twitterclient.cores.Injector;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwitterAuthenticationActivity extends Activity {

    @Inject
    AppAuthenticator mAppAuthenticator;

    @Bind(R.id.twitter_login_button)
    TwitterLoginButton mTwitterLoginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_authentication);

        Injector.inject(this);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.twitter_login_button)
    public void authentication() {
        mTwitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession session = Twitter.getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;
                mAppAuthenticator.login(token, secret);
                System.out.println("Login Successed");
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });
    }
}
