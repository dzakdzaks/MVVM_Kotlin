package com.dzakdzaks.mvvmkotlina.data.offline

import androidx.room.Room
import com.dzakdzaks.mvvmkotlina.MyApplication
import com.dzakdzaks.mvvmkotlina.model.MuseumEntity

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Friday, 17 January 2020 at 10:15.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data.offline
 * ==================================//==================================
 * ==================================//==================================
 */

const val TAG = "CONSOLE"

class OfflineRepository {

    private val db =
        Room.databaseBuilder(MyApplication.applicationContext(), MyDB::class.java, "MyDB").build()

    fun saveMuseums(museumEntity: MuseumEntity) {
        db.museumDao().saveMuseums(museumEntity)
    }

    fun getMuseums(): List<MuseumEntity> {
        return db.museumDao().getAllMuseums()
    }

}