package com.common.shy.englishmodule.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.shy.basemodule.dispatcher.ActivityDispatcher;
import com.common.shy.commonutils.voice.VoiceManager;
import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.adapter.CatalogueAdapter;
import com.common.shy.englishmodule.activity.pojo.Catalogue;
import com.common.shy.englishmodule.activity.repository.WordsRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Route(path = ActivityDispatcher.ENG_CATALOGUE_ACTIVITY)
public class CatalogueActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private CatalogueAdapter mAdapter;
    private List<Catalogue> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_catalogue_main);
        initView();
        initData();
    }

    private void initView() {
        mRecycleView = findViewById(R.id.recycle);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        mData = new ArrayList<>();
        HashMap<String, List> repos = WordsRepository.getWordsRepository().getmDifferentCategories();
        for (String title : repos.keySet()) {
            mData.add(new Catalogue(title,"90%"));
        }
        mAdapter = new CatalogueAdapter(mData);
        mAdapter.setmClickListener((position, type) -> {
            Catalogue catalogue = mData.get(position);
            ActivityDispatcher.toSpellingActivity(catalogue.title);
        });
        mRecycleView.setAdapter(mAdapter);
    }
}
