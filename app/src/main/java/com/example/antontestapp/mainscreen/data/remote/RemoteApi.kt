package com.example.antontestapp.mainscreen.data.remote

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RemoteApi {

    //todo we must not use Any
    @POST("path/path/path")
    fun requestData(
            @Body callRequest: Any
    ): Single<Response<Any>>
}