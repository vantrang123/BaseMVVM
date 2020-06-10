package com.example.basemvvm.viewmodel.base

import androidx.lifecycle.LiveData
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable

interface IBaseViewModel {
    val onPermissionStateChange: LiveData<Boolean>
    fun addDisposable(disposable: Disposable, isSaveDisposable: Boolean = false)
    fun setRxPermission(rxPermissions: RxPermissions?)
    fun onCheckPermissionStateChange(listener: ((granted: Boolean) -> Unit)? = null)
    fun onCreate()
    fun onStart()
    fun onPause()
    fun onResume()
    fun onStop()
    fun onDestroy()
}