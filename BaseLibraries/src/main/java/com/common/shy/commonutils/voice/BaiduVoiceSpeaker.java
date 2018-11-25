package com.common.shy.commonutils.voice;

import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.common.shy.commonutils.BaseApplication;
import com.common.shy.commonutils.BuildConfig;
import com.common.shy.commonutils.utils.Logger;

/**
 * http://ai.baidu.com/docs#/TTS-Android-SDK/14b0ed4d
 * https://console.bce.baidu.com/ai/?fromai=1#/ai/speech/app/detail~appId=654494
 */
public class BaiduVoiceSpeaker implements VoiceSpeaker {

    private static final String TAG = "BaiduVoiceSpeaker";

    SpeechSynthesizer mSpeechSynthesizer;

    @Override
    public void init() {
        mSpeechSynthesizer = SpeechSynthesizer.getInstance();
        mSpeechSynthesizer.setContext(BaseApplication.getApplication());
        mSpeechSynthesizer.setAppId(BuildConfig.BV_APP_ID);
        mSpeechSynthesizer.setApiKey(BuildConfig.BV_APP_KEY, BuildConfig.BV_SECRET_KEY);
        mSpeechSynthesizer.setSpeechSynthesizerListener(new SpeechSynthesizerListener() {
            @Override
            public void onSynthesizeStart(String s) {
                Logger.e(TAG, "onSynthesizeStart---s=" + s);
            }

            @Override
            public void onSynthesizeDataArrived(String s, byte[] bytes, int i) {
                Logger.e(TAG, "onSynthesizeDataArrived---s=" + s + "i=" + i);
            }

            @Override
            public void onSynthesizeFinish(String s) {
                Logger.e(TAG, "onSynthesizeFinish---s=" + s);
            }

            @Override
            public void onSpeechStart(String s) {
                Logger.e(TAG, "onSpeechStart---s=" + s);
            }

            @Override
            public void onSpeechProgressChanged(String s, int i) {
                Logger.e(TAG, "onSpeechProgressChanged---s=" + s + "i=" + i);
            }

            @Override
            public void onSpeechFinish(String s) {
                Logger.e(TAG, "onSpeechFinish---s=" + s);
            }

            @Override
            public void onError(String s, SpeechError speechError) {
                Logger.e(TAG, "s=" + s + "speechError=" + speechError.description);
            }
        });
        mSpeechSynthesizer.auth(TtsMode.MIX);
        mSpeechSynthesizer.initTts(TtsMode.MIX);
    }

    @Override
    public void speakText(String text) {
        mSpeechSynthesizer.speak(text);
    }

    @Override
    public void release() {
        mSpeechSynthesizer.release();
        mSpeechSynthesizer = null;
    }
}
