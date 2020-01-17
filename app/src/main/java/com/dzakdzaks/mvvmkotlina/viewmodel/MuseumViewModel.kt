package com.dzakdzaks.mvvmkotlina.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dzakdzaks.mvvmkotlina.data.PublicRepository
import com.dzakdzaks.mvvmkotlina.model.MuseumEntity

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:38.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.viewmodel
 * ==================================//==================================
 * ==================================//==================================
 */

class MuseumViewModel(private val repository: PublicRepository) : ViewModel() {

    init {
        repo = repository
    }

    companion object {
        var repo: PublicRepository? = null
    }

    fun loadMuseums(): LiveData<List<MuseumEntity>> {
        return repository.retrieveMuseums()
    }

//    private val _museums = MutableLiveData<List<Museum>>().apply { value = emptyList() }
//    val museums: LiveData<List<Museum>> = _museums
//
//    private val _isViewLoading = MutableLiveData<Boolean>()
//    val isViewLoading: LiveData<Boolean> = _isViewLoading
//
//    private val _onMessageError = MutableLiveData<Any>()
//    val onMessageError: LiveData<Any> = _onMessageError
//
//    private val _isEmptyList = MutableLiveData<Boolean>()
//    val isEmptyList: LiveData<Boolean> = _isEmptyList

    /*
   If you require that the data be loaded only once, you can consider calling the method
   "loadMuseums()" on constructor. Also, if you rotate the screen, the service will not be called.
    */

//    init {
//        loadMuseums()
//    }

//    fun loadMuseum() {
//        _isViewLoading.postValue(true)
//        repository.retrieveMuseums(object : OperationCallback {
//            override fun onSuccess(obj: Any?) {
//                _isViewLoading.postValue(false)
//                if (obj != null && obj is List<*>) {
//                    if (obj.isEmpty()) {
//                        _isEmptyList.postValue(true)
//                    } else {
//                        _museums.value = obj as List<Museum>
//                    }
//                }
//            }
//
//            override fun onError(obj: Any?) {
//                _isViewLoading.postValue(false)
//                _onMessageError.postValue(obj)
//            }
//
//        })
//    }
}