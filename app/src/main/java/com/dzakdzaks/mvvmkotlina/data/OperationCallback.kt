package com.dzakdzaks.mvvmkotlina.data

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:24.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data
 * ==================================//==================================
 * ==================================//==================================
 */

interface OperationCallback {
    fun onSuccess(obj: Any?)
    fun onError(obj: Any?)
}