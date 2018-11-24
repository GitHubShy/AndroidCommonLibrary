package com.common.shy.englishmodule.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.shy.basemodule.dispatcher.ActivityDispatcher;
import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.pojo.Catalogue;
import com.common.shy.englishmodule.databinding.EngDataBindingBinding;

@Route(path = ActivityDispatcher.ENG_DATA_BINDING_ACTIVITY)
public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EngDataBindingBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.eng_data_binding);
        Catalogue catalogue = new Catalogue("Test", "100%");
        viewDataBinding.setCatalogue(catalogue);
    }
}
