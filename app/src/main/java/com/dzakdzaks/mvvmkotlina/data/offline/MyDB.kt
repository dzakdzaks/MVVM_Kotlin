package com.dzakdzaks.mvvmkotlina.data.offline

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dzakdzaks.mvvmkotlina.model.MuseumEntity

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Friday, 17 January 2020 at 10:34.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data.offline
 * ==================================//==================================
 * ==================================//==================================
 */

@Database(entities = [(MuseumEntity::class)], version = 1)
abstract class MyDB : RoomDatabase() {

    abstract fun museumDao(): MuseumDao
}