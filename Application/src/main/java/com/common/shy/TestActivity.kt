package com.common.shy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.common.shy.commonutils.ListUtils
import com.common.shy.commonutils.NetUtils
import com.common.shy.commonutils.StringUtils

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        StringUtils.isEmpty("aa")
        ListUtils.removeDuplicateWithOrder(null)
        Log.e("111111111","="+NetUtils.isNetAvailable(this))
    }
}
