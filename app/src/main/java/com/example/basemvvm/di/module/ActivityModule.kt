package com.example.basemvvm.di.module

import com.example.basemvvm.di.scope.ActivityScope
import com.example.basemvvm.ui.main.MainActivity
import com.example.basemvvm.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity
}