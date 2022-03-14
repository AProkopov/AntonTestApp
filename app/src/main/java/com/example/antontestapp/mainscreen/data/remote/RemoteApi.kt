package com.example.antontestapp.mainscreen.data.remote

import com.example.antontestapp.mainscreen.data.remote.source_a.SourceAResponse
import com.example.antontestapp.mainscreen.data.remote.source_b.SourceBResponse
import com.example.antontestapp.mainscreen.data.remote.source_c.SourceCItemDto
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface RemoteApi {

    companion object {
        // Sure it is possible to get equal parts of these links and to keep them in the variables.
        // But due that these links are only test ones, let's keep them "as is"
        private const val PATH_SOURCE_A = "woodspoonstaging/raw/upload/v1645473019/assignments/mobile_homework_datasource_a_tguirv.json"
        private const val PATH_SOURCE_B = "woodspoonstaging/raw/upload/v1645473019/assignments/mobile_homework_datasource_b_x0farp.json"
        private const val PATH_SOURCE_C = "woodspoonstaging/raw/upload/v1645517666/assignments/mobile_homework_datasource_c_fqsu4l.json"
    }

    @GET(PATH_SOURCE_A)
    fun requestDataA(): Single<Response<SourceAResponse>>

    @GET(PATH_SOURCE_B)
    fun requestDataB(): Single<Response<SourceBResponse>>

    @GET(PATH_SOURCE_C)
    fun requestDataC(): Single<Response<List<SourceCItemDto>>>
}