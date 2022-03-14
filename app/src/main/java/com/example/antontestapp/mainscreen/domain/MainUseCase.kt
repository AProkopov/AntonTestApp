package com.example.antontestapp.mainscreen.domain

import com.example.antontestapp.mainscreen.data.remote.RemoteService
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val remoteService: RemoteService
){

    fun getData() = remoteService.getData()

}