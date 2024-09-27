package com.ip.locator.di

fun appModule() = listOf(
    provideHttpClientModule,
    provideDataSourcesModule,
    provideRepositoryModule,
    useCaseModule,
    provideViewModelModule
)
