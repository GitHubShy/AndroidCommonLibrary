package com.common.shy.commonutils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object  NetUtils {
    @SuppressLint("MissingPermission")
    fun isNetAvailable (context : Context) : Boolean {
        if (context != null) {
            val connectivityManager : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
            val netWorkInfo : NetworkInfo = connectivityManager.activeNetworkInfo
            if (netWorkInfo != null) {
                return  netWorkInfo.isAvailable
            }
        }
        return false
    }
}