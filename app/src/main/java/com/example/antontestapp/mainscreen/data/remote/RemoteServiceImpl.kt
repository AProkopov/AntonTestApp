package com.example.antontestapp.mainscreen.data.remote

import com.example.antontestapp.mainscreen.data.remote.source_a.SourceAResponse
import com.example.antontestapp.mainscreen.data.remote.source_b.SourceBResponse
import com.example.antontestapp.mainscreen.data.remote.source_c.SourceCItemDto
import io.reactivex.Single

class RemoteServiceImpl(
    private val remoteApi: RemoteApi,
    private val errorHandler: RestErrorHandler
    ): RemoteService {

    override fun getDataA(): Single<SourceAResponse> {
        return remoteApi.requestDataA()
            .compose(errorHandler.get())
    }

    override fun getDataB(): Single<SourceBResponse> {
        return remoteApi.requestDataB()
            .compose(errorHandler.get())
    }

    override fun getDataC(): Single<List<SourceCItemDto>> {
        return remoteApi.requestDataC()
            .compose(errorHandler.get())
    }
}