package com.example.basemvvm.application

import android.app.Activity
import android.app.Application
import android.os.Bundle
import dagger.android.AndroidInjector
import dagger.android.HasBroadcastReceiverInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication(), Application.ActivityLifecycleCallbacks,
    HasBroadcastReceiverInjector {

    lateinit var component: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        return component
    }

    override fun onActivityPaused(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityStarted(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        TODO("Not yet implemented")
    }

    override fun onActivityStopped(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onActivityResumed(activity: Activity) {
        TODO("Not yet implemented")
    }
}