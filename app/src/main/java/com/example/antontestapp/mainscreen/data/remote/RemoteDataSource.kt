package com.example.antontestapp.mainscreen.data.remote

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val okHttpClient: OkHttpClient
) {

    companion object {
        private const val BASE_URL = "https://stackoverflow.com/"
    }

    fun <Api> buildApi(
        api: Class<Api>,
        context: Context
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}