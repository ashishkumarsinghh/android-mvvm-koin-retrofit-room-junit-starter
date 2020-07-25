package com.example.android_mvvm_koin_retrofit_room_junit_starter

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl((BASE_URL))
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
        }
    }
}