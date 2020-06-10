package com.example.basemvvm.viewmodel.base

import androidx.lifecycle.*
import com.example.basemvvm.common.Constants
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(), IBaseViewModel, LifecycleObserver{
    protected var mRxPermissions: RxPermissions? = null
    protected var _onPermissionsBluetooth = MutableLiveData<Boolean>()
    private var compositeDisposable = CompositeDisposable()
    private var mCurrentDisposable: Disposable? = null
    protected var _onPermissionStateChange = MutableLiveData<Boolean>()


    override fun setRxPermission(rxPermissions: RxPermissions?) {
        mRxPermissions = rxPermissions
    }

    override fun addDisposable(disposable: Disposable, isSaveDisposable: Boolean) {
        if (mCurrentDisposable != null) {
            mCurrentDisposable?.dispose()
        }
        if (isSaveDisposable) {
            mCurrentDisposable = disposable
        }
        if (compositeDisposable.isDisposed) compositeDisposable = CompositeDisposable()
        compositeDisposable.add(disposable)
    }

    override val onPermissionStateChange: LiveData<Boolean>
        get() = _onPermissionStateChange

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
    }

}