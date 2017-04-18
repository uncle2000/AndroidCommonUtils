package com.uncle2000.androidcommonutils;

import android.app.Application;

import com.uncle2000.androidcommonutils.uitls.PermissionUtil;

/**
 * Created by 2000 on 2017/4/18.
 */

public class App extends Application {

    public static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}
