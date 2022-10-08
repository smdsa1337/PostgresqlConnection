package com.smdsa.postgresqlconnection.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitInterface {

    @GET("/")
    fun getAll() : Call<ArrayList<WordsDataClass>>

    @POST("/")
    fun saveWord(@Body wordsDataClass: WordDataClassPost) : Call<WordDataClassPost>
}