package com.dzakdzaks.mvvmkotlina.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Friday, 17 January 2020 at 9:58.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data.offline
 * ==================================//==================================
 * ==================================//==================================
 */

@Entity
class MuseumEntity {

    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 0

    @Json(name = "name")
    @ColumnInfo(name = "name")
    var name: String = ""

    @Json(name = "photo")
    @ColumnInfo(name = "photo")
    var photo: String = ""

}