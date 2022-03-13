package com.example.antontestapp.mainscreen.ui

import javax.inject.Inject

class MainUi @Inject constructor(private val mainVm: MainVm) {

    fun testGetVm() = mainVm.testGetUseCase()
}