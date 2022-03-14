package com.example.antontestapp.mainscreen.data.remote

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface RemoteApi {

    companion object {
        private const val PATH_SOURCE_A = "woodspoonstaging/raw/upload/v1645473019/assignments/mobile_homework_datasource_a_tguirv.json"
    }

    //todo we must not use Any
    @GET(PATH_SOURCE_A)
    fun requestData(): Single<Response<Any>>
}