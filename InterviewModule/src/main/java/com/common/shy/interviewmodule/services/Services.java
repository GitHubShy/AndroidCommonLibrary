package com.common.shy.interviewmodule.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.common.shy.commonutils.utils.Logger;

public class Services extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.e("11111111111","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.e("1111111111","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Logger.e("111111111","onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Logger.e("11111111111","onUnbind");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Logger.e("111111111","onBind");
        return null;
    }
}
