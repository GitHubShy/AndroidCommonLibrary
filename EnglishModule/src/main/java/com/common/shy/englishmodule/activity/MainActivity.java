package com.common.shy.englishmodule.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.common.shy.commonutils.Logger;
import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.repository.WordsRepository;
@Route(path = "/test/activity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_activity_main);
        WordsRepository.getWordsRepository();
        getApplication().getClass().toString();
        Logger.e("1111111","="+getApplication().getClass().getName());
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/test/Main2Activity").navigation();
            }
        });
    }
}
