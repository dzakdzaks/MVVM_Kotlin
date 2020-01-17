package com.dzakdzaks.mvvmkotlina.di

import com.dzakdzaks.mvvmkotlina.data.PublicRepository
import com.dzakdzaks.mvvmkotlina.data.offline.OfflineRepository
import com.dzakdzaks.mvvmkotlina.data.online.OnlineRepository

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
    fun providerMuseumRepo(): PublicRepository {
        return PublicRepository(OfflineRepository(), OnlineRepository())
    }
}