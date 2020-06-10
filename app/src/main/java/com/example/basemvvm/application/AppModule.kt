package com.example.basemvvm.application

import android.app.Application
import android.content.Context
import com.example.basemvvm.di.module.ActivityModule
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [ActivityModule::class])
class AppModule {
    @Provides
    internal fun provideApp(application: Application): Context = application
}