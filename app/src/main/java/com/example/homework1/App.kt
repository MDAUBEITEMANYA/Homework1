package com.example.homework1

import android.app.Application
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    //http://date.jsontest.com/?service=ip
    //http://date.jsontest.com/?service=date

    lateinit var api: MoshaAPI
    override fun onCreate() {
        super.onCreate()
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MoshaAPI::class.java)
    }

    companion object {
        private const val BASE_URL = "http://date.jsontest.com/"
    }
}