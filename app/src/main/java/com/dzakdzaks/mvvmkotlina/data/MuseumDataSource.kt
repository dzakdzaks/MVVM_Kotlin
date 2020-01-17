package com.dzakdzaks.mvvmkotlina.data

import com.dzakdzaks.mvvmkotlina.callback.OperationCallback

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:27.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.model
 * ==================================//==================================
 * ==================================//==================================
 */

interface MuseumDataSource {
    fun retrieveMuseums(callback: OperationCallback)
    fun cancel()
}