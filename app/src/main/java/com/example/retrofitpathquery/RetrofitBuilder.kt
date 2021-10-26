package com.example.retrofitpathquery

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val BaseUrl = "https://jsonplaceholder.typicode.com/"
    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val postApi : ApiService = getRetrofit().create(ApiService::class.java)
}