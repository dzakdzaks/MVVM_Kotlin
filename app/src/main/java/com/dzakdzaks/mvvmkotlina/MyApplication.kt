package com.dzakdzaks.mvvmkotlina

import android.app.Application
import android.content.Context

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Friday, 17 January 2020 at 10:17.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina
 * ==================================//==================================
 * ==================================//==================================
 */

class MyApplication : Application() {

    init {
        instance = this
    }


    companion object {
        private var instance: MyApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}