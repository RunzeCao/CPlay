package com.example.cplay;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

public class BaseApplication extends Application {
    private static final String LOGGER_TAG = "CPLAY";
    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        application = this;
        mainTid = android.os.Process.myTid();
        handler = new Handler();
    }

    private void initLogger() {
        Logger
                .init(LOGGER_TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(2);              // default 0
        //.logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
    }

    public static Context getApplication() {
        return application;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }


}
