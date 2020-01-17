package com.dzakdzaks.mvvmkotlina.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dzakdzaks.mvvmkotlina.callback.OperationCallback
import com.dzakdzaks.mvvmkotlina.data.offline.OfflineRepository
import com.dzakdzaks.mvvmkotlina.data.online.OnlineRepository
import com.dzakdzaks.mvvmkotlina.model.MuseumEntity
import com.dzakdzaks.mvvmkotlina.utils.Utils
import com.google.gson.Gson

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:28.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.model
 * ==================================//==================================
 * ==================================//==================================
 */

const val TAG = "CONSOLE"

class PublicRepository constructor(
    private var offlineRepository: OfflineRepository,
    private var onlineRepository: OnlineRepository
) : PublicDataSource {

    private val _museums = MutableLiveData<List<MuseumEntity>>().apply { value = emptyList() }
    private val museums: LiveData<List<MuseumEntity>> = _museums

    private val _isViewLoading = MutableLiveData<Boolean>()
    private val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    private val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    private val isEmptyList: LiveData<Boolean> = _isEmptyList


    override fun isLoading(): LiveData<Boolean> {
        return isViewLoading
    }

    override fun onErrorMessage(): LiveData<Any> {
        return onMessageError
    }

    override fun listIsEmpty(): LiveData<Boolean> {
        return isEmptyList
    }

    private fun getLocalMuseums(): List<MuseumEntity>? {
        var list: List<MuseumEntity>? = null
        Thread {
            Thread.sleep(10)
            list = offlineRepository.getMuseums()
        }.start()
        Thread.sleep(25)
        return list
    }

    override fun retrieveMuseums(): LiveData<List<MuseumEntity>> {
        if (!Utils.isConnectedToInternet()) {
            _museums.value = getLocalMuseums()
        } else {
            _isViewLoading.value = true
            onlineRepository.retrieveMuseums(object : OperationCallback {
                override fun onSuccess(obj: Any?) {
                    _isViewLoading.value = false
                    if (obj != null && obj is List<*>) {
                        if (obj.isEmpty()) {
                            _isEmptyList.value = true
                        } else {
                            _museums.value = obj as List<MuseumEntity>
                            Thread {
                                Thread.sleep(10)
                                for (item in obj) {
                                    val museumEntity = MuseumEntity()
                                    museumEntity.id = item.id
                                    museumEntity.name = item.name
                                    museumEntity.photo = item.photo
                                    offlineRepository.saveMuseums(museumEntity)
                                }
                                Log.d("loglog", Gson().toJson(offlineRepository.getMuseums()))
                            }.start()

                        }
                    }
                }

                override fun onError(obj: Any?) {
                    _isViewLoading.value = false
                    _onMessageError.value = obj
                }
            })
        }
        return museums
    }
}