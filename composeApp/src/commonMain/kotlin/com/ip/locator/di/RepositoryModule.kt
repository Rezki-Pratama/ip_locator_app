package com.ip.locator.di

import com.ip.locator.data.remote.repository.Repository
import com.ip.locator.domain.repository.IRepository
import org.koin.dsl.module


val provideRepositoryModule = module {
    single<IRepository> { Repository(get()) }
}