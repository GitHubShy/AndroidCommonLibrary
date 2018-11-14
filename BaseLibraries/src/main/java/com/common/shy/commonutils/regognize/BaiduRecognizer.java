package com.common.shy.commonutils.regognize;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.GeneralBasicParams;
import com.baidu.ocr.sdk.model.GeneralResult;
import com.common.shy.commonutils.utils.FileUtils;
import com.common.shy.commonutils.utils.Logger;

import java.io.File;
import java.io.IOException;

public class BaiduRecognizer implements Recognizer {
    @Override
    public void init(Context context) {
        OCR.getInstance(context).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                // 调用成功，返回AccessToken对象
                String token = result.getAccessToken();
                Logger.e("1111111111","token="+token);
            }
            @Override
            public void onError(OCRError error) {
                Logger.e("1111111111111111","error="+error.toString());
            }
        }, context, "Qy4moP3H62gPQkLCXNtZUB2b", "OPh8mU1S6OLsOvLZM0fL9miQuMOGfrOw");
    }

    @Override
    public void recognize(Bitmap bitmap) {
        // 通用文字识别参数设置
//        GeneralBasicParams param = new GeneralBasicParams();
//        param.setImageFile(f);
//        param.setLanguageType(GeneralBasicParams.ENGLISH);
//
//        OCR.getInstance(getApplication()).recognizeGeneralBasic(param, new OnResultListener<GeneralResult>() {
//            @Override
//            public void onResult(GeneralResult result) {
//                // 调用成功，返回GeneralResult对象
//                Logger.e("111111111111","result=="+result.toString());
//                for (WordSimple wordSimple : result.getWordList()) {
//                    Logger.e("111111111111","result=="+wordSimple.getWords());
//                }
//            }
//            @Override
//            public void onError(OCRError error) {
//                Logger.e("111111111111","error=="+error.toString());
//            }
//        });
        File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/a.png");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileUtils.bitmapToFile(bitmap, f);
        GeneralBasicParams param = new GeneralBasicParams();
        param.setDetectDirection(true);
        param.setImageFile(f);
        param.setLanguageType(GeneralBasicParams.ENGLISH);

//        OCR.getInstance(getApplication()).recognizeAccurateBasic(param, new OnResultListener<GeneralResult>() {
//            @Override
//            public void onResult(GeneralResult result) {
//                for (WordSimple wordSimple : result.getWordList()) {
//                    Logger.e("111111111111","result=="+wordSimple.getWords());
//                }
//                // json格式返回字符串
//            }
//            @Override
//            public void onError(OCRError error) {
//                // 调用失败，返回OCRError对象
//            }
//        });
    }
}
