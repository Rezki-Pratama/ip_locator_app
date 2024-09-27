package com.ip.locator.data.remote.datasource

import com.ip.locator.data.remote.response.IPAddressResponse
import com.ip.locator.data.remote.response.NetworkError
import com.ip.locator.data.remote.response.Results
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {
    fun searchIpAddress(query: String): Flow<Results<IPAddressResponse, NetworkError>>
}