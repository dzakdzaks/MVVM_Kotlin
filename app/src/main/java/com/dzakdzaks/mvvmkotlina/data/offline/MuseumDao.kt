package com.dzakdzaks.mvvmkotlina.data.offline

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dzakdzaks.mvvmkotlina.model.MuseumEntity

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Friday, 17 January 2020 at 10:13.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data.offline
 * ==================================//==================================
 * ==================================//==================================
 */

@Dao
interface MuseumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMuseums(museumEntity: MuseumEntity)

    @Query(value = "SELECT * FROM MuseumEntity")
    fun getAllMuseums(): List<MuseumEntity>

}