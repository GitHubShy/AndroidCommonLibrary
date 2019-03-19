package com.common.shy.acitvity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.common.shy.basemodule.dispatcher.ActivityDispatcher;
import com.common.shy.englishmodule.R;


public class MainActivity extends AppCompatActivity {


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
        findViewById(R.id.service).setOnClickListener(view -> {
            ActivityDispatcher.toServiceFirstActivity();
        });
    }
}
