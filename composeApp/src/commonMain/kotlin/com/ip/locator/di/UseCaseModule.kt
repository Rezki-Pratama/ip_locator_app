package com.ip.locator.di

import com.ip.locator.domain.usecase.Interactor
import com.ip.locator.domain.usecase.UseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<UseCase> { Interactor(get()) }
}