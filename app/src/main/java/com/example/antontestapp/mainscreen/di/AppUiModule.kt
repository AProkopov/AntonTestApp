package com.example.antontestapp.mainscreen.di

import com.example.antontestapp.mainscreen.ui.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppUiModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

}