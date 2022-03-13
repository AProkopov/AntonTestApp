package com.medisafe.pillshapetest.base

import android.view.View
import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

private typealias AndroidFragment = androidx.fragment.app.Fragment

abstract class FragmentLifecycleObserver<Fragment : AndroidFragment>(
    protected val fragment: Fragment,
    postponeInitialize: Boolean = false
) : LifecycleObserver {


    protected val onStartStopDisposable = CompositeDisposable()
    protected val onCreateDestroyDisposable = CompositeDisposable()

    init {
        if (!postponeInitialize) {
            initialize()
        }
    }

    fun initialize() {
        fragment.lifecycle.addObserver(this)

        fragment.viewLifecycleOwnerLiveData.observe(fragment, object : Observer<LifecycleOwner> {
            override fun onChanged(t: LifecycleOwner?) {
                subscribeToViewLifecycle()
            }
        })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent() {
        onCreate()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyEvent() {
        onDestroy()
    }

    protected open fun onCreate() {}

    protected open fun onViewReady(view: View) {}

    protected open fun onStart(view: View) {}

    protected open fun onStop(view: View) {}

    protected open fun onViewDestroy() {}

    protected open fun onDestroy() {}

    protected fun Disposable?.disposeOnDestroyFragment() {
        if (this != null) {
            onCreateDestroyDisposable.add(this)
        }
    }

    protected fun Disposable?.disposeOnDestroyView() {
        if (this != null) {
            onCreateDestroyDisposable.add(this)
        }
    }

    private fun subscribeToViewLifecycle() {
        fragment.viewLifecycleOwner.lifecycle.addObserver(object :
            LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                onViewReady(fragment.requireView())
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                onCreateDestroyDisposable.clear()
                onViewDestroy()
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStartEvent() {
                fragment.view?.let(::onStart)
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStopEvent() {
                onStartStopDisposable.clear()
                fragment.view?.let(::onStop)
            }
        })
    }
}