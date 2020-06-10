package com.example.basemvvm.application

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Singleton
import android.app.Application
import com.example.basemvvm.di.module.ActivityModule
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}