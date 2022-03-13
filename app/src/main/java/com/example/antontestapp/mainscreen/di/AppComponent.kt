package com.example.antontestapp.mainscreen.di

import com.example.antontestapp.base.AntonTestApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        AppUiModule::class
    ]
)
interface AppComponent {
    fun inject(application: AntonTestApplication)
}