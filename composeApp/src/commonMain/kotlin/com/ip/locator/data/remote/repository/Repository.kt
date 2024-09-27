package com.ip.locator.data.remote.repository

import com.ip.locator.data.remote.datasource.IRemoteDataSource
import com.ip.locator.data.remote.response.NetworkError
import com.ip.locator.data.remote.response.Results
import com.ip.locator.domain.model.IPAddress
import com.ip.locator.domain.repository.IRepository
import com.ip.locator.utils.mapIpAddressResponseToApiAddress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(private val remoteDataSource: IRemoteDataSource) : IRepository {

    override fun searchIpAddress(query: String): Flow<Results<IPAddress, NetworkError>> {
        return remoteDataSource.searchIpAddress(query).map { result ->
            when (result) {
                is Results.Success -> {
                    // Map the IPAddressResponse to ApiAddress
                    val apiAddress = mapIpAddressResponseToApiAddress(result.data)
                    Results.Success(apiAddress)
                }
                is Results.Error -> {
                    // Pass through the error
                    Results.Error(result.error)
                }
            }
        }
    }
}

