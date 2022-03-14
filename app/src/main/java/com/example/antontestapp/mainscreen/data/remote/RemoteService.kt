package com.example.antontestapp.mainscreen.data.remote

import io.reactivex.Single

interface RemoteService {

    fun getData(): Single<Any>

}