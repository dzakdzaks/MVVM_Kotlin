package com.dzakdzaks.mvvmkotlina.model.response

import com.dzakdzaks.mvvmkotlina.model.MuseumEntity

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:22.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data
 * ==================================//==================================
 * ==================================//==================================
 */

data class MuseumResponse(val status: Int?, val msg: String?, val data: List<MuseumEntity>?) {
    fun isSuccess(): Boolean = (status == 200)
}