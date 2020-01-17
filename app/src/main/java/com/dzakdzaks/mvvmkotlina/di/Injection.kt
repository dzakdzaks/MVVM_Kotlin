package com.dzakdzaks.mvvmkotlina.di

import com.dzakdzaks.mvvmkotlina.data.MuseumDataSource
import com.dzakdzaks.mvvmkotlina.data.MuseumRepository

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:24.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.di
 * ==================================//==================================
 * ==================================//==================================
 */

object Injection {
    fun providerMuseumRepo(): MuseumDataSource {
        return MuseumRepository()
    }
}