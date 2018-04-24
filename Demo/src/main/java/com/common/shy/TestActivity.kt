package com.common.shy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.common.shy.commonutils.StringUtils

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        StringUtils.isEmpty("aa")
    }
}
