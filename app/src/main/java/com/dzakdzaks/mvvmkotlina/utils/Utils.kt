package com.dzakdzaks.mvvmkotlina.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.dzakdzaks.mvvmkotlina.MyApplication

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Friday, 17 January 2020 at 14:31.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.utils
 * ==================================//==================================
 * ==================================//==================================
 */

class Utils {

    companion object {
        fun isConnectedToInternet(): Boolean {
            val connectivity = MyApplication.applicationContext().getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            val info = connectivity.allNetworkInfo
            if (info != null)
                for (i in info.indices)
                    if (info[i].state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
            return false
        }
    }

}