package com.dzakdzaks.mvvmkotlina.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dzakdzaks.mvvmkotlina.data.PublicRepository


/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:37.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.viewmodel
 * ==================================//==================================
 * ==================================//==================================
 */

class ViewModelFactory(private val repository: PublicRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MuseumViewModel::class.java)) {
            return MuseumViewModel(repository) as T
        }

        throw IllegalArgumentException("ViewModel dengan nama " + modelClass.name + " tidak ditemukan.")
    }

}