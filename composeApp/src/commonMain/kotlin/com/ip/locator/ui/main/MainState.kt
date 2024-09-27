package com.ip.locator.ui.main

import com.ip.locator.domain.model.IPAddress

data class MainState(
    val ipAddress: IPAddress = IPAddress.empty,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
)