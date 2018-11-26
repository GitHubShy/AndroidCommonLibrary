package com.common.shy.englishmodule.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.common.shy.basemodule.dispatcher.ActivityDispatcher;
import com.common.shy.commonutils.http.HttpRequestManager;
import com.common.shy.englishmodule.R;

import java.util.HashMap;

public class EngMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_activity_main2);
        findViewById(R.id.spelling).setOnClickListener(view -> {
            ActivityDispatcher.toCatalogueActivity();
        });
        findViewById(R.id.data_binding).setOnClickListener(view -> {
            ActivityDispatcher.toDataBindingActivity();
        });
    }
}
