package com.common.shy.commonutils.regognize;

import android.content.Context;
import android.graphics.Bitmap;

public class RecognizeManager {

    private static volatile RecognizeManager mRecognizeManager;

    private Recognizer mRecognizer;

    private RecognizeManager(Context context) {
        mRecognizer = new TessRecognizer();
        mRecognizer.init(context);
    }

    public static RecognizeManager getInstance(Context context) {
        if (mRecognizeManager == null) {
            synchronized (RecognizeManager.class) {
                if (mRecognizeManager == null) {
                    mRecognizeManager = new RecognizeManager(context);
                }
            }
        }
        return mRecognizeManager;
    }

    public void recognizeEnglish(Bitmap bitmap) {
        mRecognizer.recognize(bitmap);
    }
}
