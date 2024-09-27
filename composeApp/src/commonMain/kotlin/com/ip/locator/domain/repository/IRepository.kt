package com.ip.locator.domain.repository

import com.ip.locator.data.remote.response.NetworkError
import com.ip.locator.data.remote.response.Results
import com.ip.locator.domain.model.IPAddress
import kotlinx.coroutines.flow.Flow

interface IRepository {
     fun searchIpAddress(query:String): Flow<Results<IPAddress, NetworkError>>
}