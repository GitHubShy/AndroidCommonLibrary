package com.common.shy.englishmodule.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.shy.basemodule.custom.HandDrawView;
import com.common.shy.commonutils.dispatcher.ActivityDispatcher;
import com.common.shy.commonutils.utils.BitmapUtils;
import com.common.shy.englishmodule.R;

@Route(path = ActivityDispatcher.ENG_SPELLING_ACTIVITY)
public class SpellingActivity extends AppCompatActivity {

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
        mRecognize.setOnClickListener(view -> recognize());
        mClear.setOnClickListener(view -> mDrawView.clear());
    }

    private void recognize() {
        BitmapUtils.ViewToBitmap(mDrawView);
//        File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/a.png");
//        if (!f.exists()) {
//            try {
//                f.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
