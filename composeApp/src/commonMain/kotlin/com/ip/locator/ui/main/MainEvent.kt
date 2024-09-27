package com.ip.locator.ui.main

sealed interface MainEvent {
    data class SearchIpAddress(val query: String) : MainEvent
}