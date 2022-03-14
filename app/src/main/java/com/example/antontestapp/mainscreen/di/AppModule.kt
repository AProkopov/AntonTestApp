package com.example.antontestapp.mainscreen.di

import android.content.Context
import com.example.antontestapp.mainscreen.data.remote.*
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context
) {

    @Provides
    fun provideRx2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    @Provides
    fun provideOkHttpClientBuilder() = OkHttpClient.Builder()

    @Provides
    fun provideHttpClient(
        builder: OkHttpClient.Builder
    ): OkHttpClient {
        return builder.build()
    }

    @Provides
    fun provideRemoteApi(remoteDataSource: RemoteDataSource): RemoteApi {
        return remoteDataSource.buildApi(RemoteApi::class.java, context)
    }

    @Provides
    fun provideRemoteService(
        remoteApi: RemoteApi,
        errorHandler: RestErrorHandler
    ): RemoteService = RemoteServiceImpl(remoteApi, errorHandler)
}