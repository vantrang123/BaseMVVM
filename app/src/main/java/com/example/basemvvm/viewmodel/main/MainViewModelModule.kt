package com.example.basemvvm.viewmodel.main

import dagger.Binds
import dagger.Module

@Module
abstract class MainViewModelModule {
    @Binds
    abstract fun contributeMainViewModelInterface(mainViewModel: MainViewModel): IMainViewModel
}