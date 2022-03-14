package com.example.antontestapp.mainscreen.data.remote

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val callAdapterFactoryRx2: RxJava2CallAdapterFactory
) {

    companion object {
        private const val BASE_URL = "https://res.cloudinary.com/"
    }

    fun <Api> buildApi(
        api: Class<Api>,
        context: Context
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(callAdapterFactoryRx2)
            .build()
            .create(api)
    }

}