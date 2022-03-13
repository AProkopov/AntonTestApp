package com.example.antontestapp.mainscreen.ui

import com.example.antontestapp.mainscreen.domain.MainUseCase
import javax.inject.Inject

class MainVm @Inject constructor(private val mainUseCase: MainUseCase) {
    fun testGetUseCase() = mainUseCase.testGetApi()
}