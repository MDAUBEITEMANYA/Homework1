package com.example.homework1

import io.reactivex.Single
import retrofit2.http.GET

interface MoshaAPI {
    @GET("?service=ip")
    fun getIp(): Single<DataIP>

    @GET("?service=date")
    fun getDate(): Single<DataDate>
}