package com.example.antontestapp.mainscreen.data.remote

import com.example.antontestapp.mainscreen.data.remote.source_a.SourceAResponse
import com.example.antontestapp.mainscreen.data.remote.source_b.SourceBResponse
import com.example.antontestapp.mainscreen.data.remote.source_c.SourceCItemDto
import io.reactivex.Single

interface RemoteService {

    fun getDataA(): Single<SourceAResponse>
    fun getDataB(): Single<SourceBResponse>
    fun getDataC(): Single<List<SourceCItemDto>>

}