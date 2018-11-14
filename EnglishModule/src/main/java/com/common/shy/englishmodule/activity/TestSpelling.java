package com.common.shy.englishmodule.activity;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.common.shy.basemodule.custom.HandDrawView;
import com.common.shy.commonutils.regognize.RecognizeManager;
import com.common.shy.commonutils.utils.Logger;
import com.common.shy.englishmodule.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Route(path = "/test/TestSpelling")
public class TestSpelling extends AppCompatActivity {

    private Button mRecognize;
    private Button mClear;
    private HandDrawView mDrawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_activity_test_spelling);

        mRecognize = findViewById(R.id.recognize);
        mDrawView = findViewById(R.id.broad);
        mClear = findViewById(R.id.clear);
        mRecognize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recognize();
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.clear();
            }
        });
    }

    private void recognize() {
        //开启绘图缓存
        mDrawView.setDrawingCacheEnabled(true);
        //这个方法可调可不调，因为在getDrawingCache()里会自动判断有没有缓存有没有准备好，
        //如果没有，会自动调用buildDrawingCache()
        mDrawView.buildDrawingCache();
        //获取绘图缓存 这里直接创建了一个新的bitmap
        //因为我们在最后需要释放缓存资源，会释放掉缓存中创建的bitmap对象
        Bitmap bitmap = Bitmap.createBitmap(mDrawView.getDrawingCache(), 0, 0, mDrawView.getMeasuredWidth(),
                mDrawView.getMeasuredHeight());
        //清理绘图缓存，释放资源
        mDrawView.destroyDrawingCache();
        File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/a.png");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        RecognizeManager.getInstance(getApplicationContext()).recognizeEnglish(bitmap);
    }

}
