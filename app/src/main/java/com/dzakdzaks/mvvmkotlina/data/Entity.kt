package com.dzakdzaks.mvvmkotlina.data

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:22.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data
 * ==================================//==================================
 * ==================================//==================================
 */

data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}