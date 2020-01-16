package com.dzakdzaks.mvvmkotlina.model

import com.dzakdzaks.mvvmkotlina.data.OperationCallback
import javax.security.auth.callback.Callback

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