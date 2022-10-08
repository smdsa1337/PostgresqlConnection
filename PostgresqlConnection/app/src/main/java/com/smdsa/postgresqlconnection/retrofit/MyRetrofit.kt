package com.smdsa.postgresqlconnection.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {

    var retrofit: RetrofitInterface = Retrofit.Builder()
        .baseUrl("http://192.168.0.13:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(RetrofitInterface::class.java)
}