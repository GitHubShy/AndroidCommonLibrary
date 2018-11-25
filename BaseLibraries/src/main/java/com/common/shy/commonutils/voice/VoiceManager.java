package com.common.shy.commonutils.voice;


import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

import com.common.shy.commonutils.utils.Logger;

public class VoiceManager implements DefaultLifecycleObserver {

    private static final String TAG = "VoiceManager";

    private VoiceSpeaker mVoiceSpeaker;

    public VoiceManager() {
        mVoiceSpeaker = new BaiduVoiceSpeaker();
        mVoiceSpeaker.init();
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Logger.e(TAG,"onCreate");

    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Logger.e(TAG,"onStart");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Logger.e(TAG,"onResume");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Logger.e(TAG,"onPause");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Logger.e(TAG,"onStop");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Logger.e(TAG,"onDestroy");
        mVoiceSpeaker.release();
    }

    public void speakText(String text) {
        mVoiceSpeaker.speakText(text);
    }

}
