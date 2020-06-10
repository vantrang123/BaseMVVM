package com.example.basemvvm.ui.main

import com.example.basemvvm.viewmodel.main.MainViewModelModule
import dagger.Module

@Module(includes = [MainViewModelModule::class])
abstract class MainModule {
}