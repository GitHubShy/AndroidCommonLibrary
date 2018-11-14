package com.common.shy.commonutils.regognize;

import android.content.Context;
import android.graphics.Bitmap;

public interface Recognizer {
    void init(Context context);
    void recognize(Bitmap bitmap);
}
