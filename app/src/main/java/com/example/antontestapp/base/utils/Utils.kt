package com.example.antontestapp.base.utils

import android.view.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.observeOnMainThread(): Observable<T> = this.observeOn(AndroidSchedulers.mainThread())

fun <T : Disposable> T.addTo(compositeDisposable: CompositeDisposable): T {
    compositeDisposable.add(this)
    return this
}

fun View?.visible() {
    this?.visibility = View.VISIBLE
}

fun View?.gone() {
    this?.visibility = View.GONE
}

fun View.setVisibleOrGone(value: Boolean) {
    if (value) visible() else gone()
}