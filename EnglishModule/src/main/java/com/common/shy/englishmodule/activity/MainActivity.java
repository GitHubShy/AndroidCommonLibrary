package com.common.shy.englishmodule.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.repository.WordsRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_activity_main);
        WordsRepository.getWordsRepository();
    }
}
