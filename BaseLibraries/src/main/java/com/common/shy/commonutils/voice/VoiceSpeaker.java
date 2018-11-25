package com.common.shy.commonutils.voice;

import android.content.Context;

public interface VoiceSpeaker {
    void init();
    void speakText(String text);
    void release();
}
