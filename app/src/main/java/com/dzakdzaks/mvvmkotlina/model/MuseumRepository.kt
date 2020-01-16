package com.dzakdzaks.mvvmkotlina.model

import android.util.Log
import com.dzakdzaks.mvvmkotlina.data.MuseumResponse
import com.dzakdzaks.mvvmkotlina.data.OperationCallback
import com.dzakdzaks.mvvmkotlina.data.RetrofitApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 15:28.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.model
 * ==================================//==================================
 * ==================================//==================================
 */

const val TAG="CONSOLE"

class MuseumRepository : MuseumDataSource {

    private var call: Call<MuseumResponse>? = null

    override fun retrieveMuseums(callback: OperationCallback) {
        call = RetrofitApiClient.build()?.museums()
        call?.enqueue(object : Callback<MuseumResponse> {
            override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<MuseumResponse>, response: Response<MuseumResponse>) {
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

    override fun cancel() {
        call?.cancel()
    }

}