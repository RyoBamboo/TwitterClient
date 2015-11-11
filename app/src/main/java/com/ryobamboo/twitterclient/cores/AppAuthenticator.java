package com.ryobamboo.twitterclient.cores;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public class AppAuthenticator {

    private Context mContext;

    public AppAuthenticator() {
    }

    public AppAuthenticator(Context context) {
        mContext = context;
    }

    public Boolean hasAuthentication() {
        String token = getDefaultSharedPreferences(mContext).getString(Constants.Authentication.TOKEN, "");
        return !TextUtils.isEmpty(token);
    }

    public void login(String token, String secret) {
        SharedPreferences.Editor editor = getDefaultSharedPreferences(mContext).edit();
        editor.putString(Constants.Authentication.TOKEN, token);
        editor.putString(Constants.Authentication.SECRET, secret);
        editor.apply();
    }

    public void logout() {
        SharedPreferences.Editor editor = getDefaultSharedPreferences(mContext).edit();
        editor.remove(Constants.Authentication.TOKEN);
        editor.remove(Constants.Authentication.SECRET);
        editor.apply();
    }

    private SharedPreferences getDefaultSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
