package com.example.antontestapp.mainscreen.ui

import com.example.antontestapp.base.utils.addTo
import com.example.antontestapp.mainscreen.domain.MainUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainVm @Inject constructor(private val mainUseCase: MainUseCase) {

    private val compositeDisposable = CompositeDisposable()

    fun testGetUseCase() = mainUseCase.getData()
        .subscribe(
            {
                val x = it
            },
            {
                val y = it
            }
        )
        .addTo(compositeDisposable)
}