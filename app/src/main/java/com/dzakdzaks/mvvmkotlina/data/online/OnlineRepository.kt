package com.dzakdzaks.mvvmkotlina.data.online

import android.util.Log
import com.dzakdzaks.mvvmkotlina.callback.OperationCallback
import com.dzakdzaks.mvvmkotlina.model.response.MuseumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Friday, 17 January 2020 at 9:48.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.data.online
 * ==================================//==================================
 * ==================================//==================================
 */

const val TAG = "CONSOLE"

class OnlineRepository {

    private var callRetrieveMuseums: Call<MuseumResponse>? = null

    fun retrieveMuseums(callback: OperationCallback) {
        callRetrieveMuseums = RetrofitApiClient.build()?.museums()
        callRetrieveMuseums?.enqueue(object : Callback<MuseumResponse> {
            override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<MuseumResponse>,
                response: Response<MuseumResponse>
            ) {
                response.body()?.let {
                    if (response.isSuccessful && (it.isSuccess())) {
                        Log.d(TAG, "data : ${it.data}")
                        callback.onSuccess(it.data)
                    } else {
                        callback.onError(it.msg)
                    }
                }
            }

        })
    }

    fun cancelRetrieveMuseums() {
        callRetrieveMuseums?.cancel()
    }

}