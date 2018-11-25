package com.common.shy.commonutils;

import android.app.Application;
import android.content.Context;

public class BaseApplication {

    private static Application mApplication;


    public static void injectApplication (Application application) {
        mApplication = application;
    }
//    private BaseApplication(Application application) {
//        mApplication = application;
//    }
//
//    public static BaseApplication initApplication(Application application) {
//        if (mBaseApplication == null) {
//            mBaseApplication = new BaseApplication(application);
//        }
//        return mBaseApplication;
//    }

    public static Application getApplication() {
        judgeApplication ();
        return mApplication;
    }

    public static Context getContext() {
        judgeApplication ();
        return mApplication.getApplicationContext();
    }

    private static void judgeApplication () {
        if (mApplication == null) {
            throw new NullPointerException("you should init application");
        }
    }

}
