package com.ip.locator.data.remote.network.interceptor

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.util.*

class AuthInterceptor(private val tokenProvider: () -> String) {

    // Interceptor Configuration
    class Config {
        lateinit var tokenProvider: () -> String
    }

    companion object Plugin : HttpClientPlugin<Config, AuthInterceptor> {
        override val key = AttributeKey<AuthInterceptor>("AuthInterceptor")

        override fun prepare(block: Config.() -> Unit): AuthInterceptor {
            val config = Config().apply(block)
            return AuthInterceptor(config.tokenProvider)
        }

        override fun install(plugin: AuthInterceptor, scope: HttpClient) {
            // Intercept each request and add the Authorization header
            scope.requestPipeline.intercept(HttpRequestPipeline.State) {
                val token = plugin.tokenProvider()
                if (token.isNotEmpty()) {
                    context.headers.append("Authorization", "Bearer $token")
                }
                proceed()
            }
        }
    }
}