package com.ip.locator.ui.main

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.ip.locator.data.remote.response.Results
import com.ip.locator.domain.usecase.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: UseCase
) : ScreenModel {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.SearchIpAddress -> searchIpAddress(event)
        }
    }

    private fun searchIpAddress(event: MainEvent.SearchIpAddress) {
        if (_state.value.isLoading) return

        _state.update {
            it.copy(isLoading = true)
        }

        screenModelScope.launch {
            useCase.searchIpAddress(event.query)
                .collect { result ->
                    when (result) {
                        is Results.Success -> {
                            _state.update {
                                it.copy(
                                    ipAddress = result.data,
                                    isLoading = false,
                                    isSuccess = true,
                                )
                            }
                        }
                        is Results.Error -> {
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    isFailure = true,
                                )
                            }
                        }
                    }
                }
        }
    }
}