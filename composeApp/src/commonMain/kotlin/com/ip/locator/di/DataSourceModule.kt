package com.ip.locator.di

import com.ip.locator.data.remote.datasource.IRemoteDataSource
import com.ip.locator.data.remote.datasource.RemoteDataSource
import org.koin.dsl.module

val provideDataSourcesModule = module {
    single<IRemoteDataSource> { RemoteDataSource(get()) }
}