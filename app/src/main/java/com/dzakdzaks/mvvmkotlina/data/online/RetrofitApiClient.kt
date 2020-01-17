package com.dzakdzaks.mvvmkotlina.data.online

import com.dzakdzaks.mvvmkotlina.BuildConfig
import com.dzakdzaks.mvvmkotlina.model.response.MuseumResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Wednesday, 15 January 2020 at 15:38.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.service
 * ==================================//==================================
 * ==================================//==================================
 */

object RetrofitApiClient {

    private var servicesApiInterface: ServicesApiInterface? = null

    fun build(): ServicesApiInterface? {

        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptor(interceptor())

        val retrofit: Retrofit = builder.client(httpClient.build()).build()
        servicesApiInterface = retrofit.create(
            ServicesApiInterface::class.java
        )

        return servicesApiInterface as ServicesApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }


    interface ServicesApiInterface {
        @GET("api/museums/")
        fun museums(): Call<MuseumResponse>
    }

}

//private var retrofit: Retrofit? = null
//val apiClient: Retrofit
//    get() {
//        if (RetrofitApiClient.retrofit == null) {
//            val logging = HttpLoggingInterceptor()
//            logging.apply {
//                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
//            }
//
//            val client: OkHttpClient = OkHttpClient.Builder()
//                .connectTimeout(10, TimeUnit.MINUTES)
//                .readTimeout(10, TimeUnit.MINUTES)
//                .writeTimeout(10, TimeUnit.MINUTES)
//                .addInterceptor(logging)
//                .build()
//
//            RetrofitApiClient.retrofit = Retrofit.Builder()
//                .baseUrl(BuildConfig.BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        return RetrofitApiClient.retrofit!!
//    }