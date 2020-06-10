package com.example.basemvvm.ui.base

import androidx.annotation.LayoutRes

interface IView {
    @LayoutRes
    fun getLayoutRes(): Int

    fun initView();

    fun initViewModel();
}