package com.common.shy.commonutils.regognize;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.common.shy.commonutils.utils.FileUtils;
import com.common.shy.commonutils.utils.Logger;
import com.googlecode.tesseract.android.TessBaseAPI;

public class TessRecognizer implements Recognizer {


    @Override
    public void init(Context context) {
        FileUtils.assetsToSD("eng.traineddata", Environment.getExternalStorageDirectory().getAbsolutePath() + "/tessdata", context);

    }

    @Override
    public void recognize(Bitmap bitmap) {
        TessBaseAPI tessBaseAPI = new TessBaseAPI();
        tessBaseAPI.init(Environment.getExternalStorageDirectory().getAbsolutePath(),"eng");
        tessBaseAPI.setImage(bitmap);
        String text = tessBaseAPI.getUTF8Text();
        Logger.e("1111111111111111","eng="+text);
    }
}
