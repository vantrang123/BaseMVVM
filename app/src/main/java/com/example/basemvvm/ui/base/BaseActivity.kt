package com.example.basemvvm.ui.base

import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import com.example.basemvvm.viewmodel.base.IBaseViewModel
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T: IBaseViewModel> : DaggerAppCompatActivity(), IView {

    @Inject
    lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        lifecycle.addObserver(viewModel as LifecycleObserver)
        initView()
        initViewModel()
    }

    override fun initViewModel() {
        viewModel.setRxPermission(RxPermissions(this))
        viewModel.apply {
            setRxPermission(RxPermissions(this@BaseActivity))
        }
    }

    override fun initView() {

    }
}