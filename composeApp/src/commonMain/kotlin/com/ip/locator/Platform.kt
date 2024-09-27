package com.ip.locator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform