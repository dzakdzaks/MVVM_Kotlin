package com.dzakdzaks.mvvmkotlina.data

import androidx.lifecycle.LiveData
import com.dzakdzaks.mvvmkotlina.model.MuseumEntity

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:27.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.model
 * ==================================//==================================
 * ==================================//==================================
 */

interface PublicDataSource {
    fun isLoading(): LiveData<Boolean>
    fun onErrorMessage(): LiveData<Any>
    fun listIsEmpty(): LiveData<Boolean>

    fun retrieveMuseums(): LiveData<List<MuseumEntity>>
}