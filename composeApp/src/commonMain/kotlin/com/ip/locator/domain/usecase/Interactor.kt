package com.ip.locator.domain.usecase

import com.ip.locator.data.remote.response.NetworkError
import com.ip.locator.data.remote.response.Results
import com.ip.locator.domain.model.IPAddress
import com.ip.locator.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow

class Interactor(private val repository: IRepository): UseCase {
    override fun searchIpAddress(query: String)  = repository.searchIpAddress(query)
}