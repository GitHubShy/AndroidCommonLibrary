package com.common.shy.interviewmodule.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.shy.basemodule.custom.CellView;
import com.common.shy.interviewmodule.R;

public class Cell extends AppCompatActivity {

    private CellView mCellView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inter_activity_cell);
        mCellView = findViewById(R.id.view);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
