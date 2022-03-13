package com.example.antontestapp.mainscreen.di

import android.content.Context
import com.example.antontestapp.mainscreen.data.remote.RemoteApi
import com.example.antontestapp.mainscreen.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context
) {

    @Provides
    fun provideOkHttpClientBuilder() = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun provideHttpClient(
        builder: OkHttpClient.Builder
    ): OkHttpClient {
        return builder.build()
    }

    @Provides
    fun provideRemoteApi(remoteDataSource: RemoteDataSource): RemoteApi {
        return remoteDataSource.buildApi(RemoteApi::class.java, context)
    }
}