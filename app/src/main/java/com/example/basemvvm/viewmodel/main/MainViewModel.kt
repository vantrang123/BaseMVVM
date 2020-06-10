package com.example.basemvvm.viewmodel.main

import com.example.basemvvm.common.Constants
import com.example.basemvvm.event.Event
import com.example.basemvvm.event.RxEvent
import com.example.basemvvm.viewmodel.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(): BaseViewModel(), IMainViewModel {
    override fun onCheckPermissionStateChange(listener: ((granted: Boolean) -> Unit)?) {
        Constants.getPermissions().forEach {
            if (mRxPermissions?.isGranted(it) != true) {
                listener?.invoke(false)
                return
            }
        }

        listener?.invoke(true)
    }

    override fun onCreate() {
        super.onCreate()
        addDisposable(RxEvent.listen(Event.ChangePermissionStatus::class.java).subscribe {
            Timber.e("ChangePermissionStatus")
            _onPermissionStateChange.postValue(it.isOff)
        })
    }

}