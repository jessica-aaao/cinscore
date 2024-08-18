package com.example.cinscore.utils

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkHelper {
    companion object {
        fun getRetrofitInstance(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    /*private fun okHttpClient(apiKey: String) = OkHttpClient().newBuilder()
        .addInterceptor { chain ->
            val request: Request = chain.request()
                .newBuilder()
                .header("accept", "application/json")
                .header("Authorization", apiKey)
                .build()
            chain.proceed(request)
        }*/
}