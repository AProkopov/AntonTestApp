package com.example.antontestapp.mainscreen.domain

import com.example.antontestapp.mainscreen.data.remote.RemoteApi
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val api: RemoteApi
){
    fun testGetApi() = api
}