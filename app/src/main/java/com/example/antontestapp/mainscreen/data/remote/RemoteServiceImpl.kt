package com.example.antontestapp.mainscreen.data.remote

import io.reactivex.Single

class RemoteServiceImpl(
    private val remoteApi: RemoteApi,
    private val errorHandler: RestErrorHandler
    ): RemoteService {

    override fun getData(): Single<Any> {
        return remoteApi.requestData()
            .compose(errorHandler.get())
    }
}