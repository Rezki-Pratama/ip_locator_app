package com.ip.locator.di

import ApiService
import com.ip.locator.data.remote.network.interceptor.AuthInterceptor
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun getToken(): String {
    // Return the current access token
    return "your_access_token"
}

val provideHttpClientModule = module {
    single {
        HttpClient {

            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                }, contentType = ContentType.Application.Json)
            }
        }
    }

    single<ApiService> {
        ApiService(get())
    }
}