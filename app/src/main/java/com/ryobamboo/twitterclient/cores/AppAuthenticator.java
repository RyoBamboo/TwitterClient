package com.ryobamboo.twitterclient.cores;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppAuthenticator {

    private Context mContext;

    public AppAuthenticator() {
    }

    public AppAuthenticator(Context context) {
        mContext = context;
    }

    public Boolean hasAuthentication() {
        return true;
    }

    public String getToken() {
        return getDefautlSharedPreferences(mContext).getString()
    }

    private SharedPreferences getDefautlSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
