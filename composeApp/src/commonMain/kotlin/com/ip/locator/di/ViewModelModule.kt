package com.ip.locator.di

import com.ip.locator.ui.main.MainViewModel
import org.koin.dsl.module


val provideViewModelModule = module {
    factory {
        MainViewModel(get())
    }
}