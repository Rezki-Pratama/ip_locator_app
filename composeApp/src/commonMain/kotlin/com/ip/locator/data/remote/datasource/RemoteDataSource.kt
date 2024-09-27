package com.ip.locator.data.remote.datasource

import ApiService
import com.ip.locator.data.remote.response.IPAddressResponse
import com.ip.locator.data.remote.response.NetworkError
import com.ip.locator.data.remote.response.Results
import io.ktor.client.HttpClient
import io.ktor.http.HttpMethod
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(private val apiService: ApiService) : IRemoteDataSource {

    override fun searchIpAddress(query: String): Flow<Results<IPAddressResponse, NetworkError>> = flow {
        val resultFlow: Flow<Results<IPAddressResponse, NetworkError>> = apiService.executeRequest(
            endpoint = "http://ip-api.com/json/$query?fields=status,message,continent,continentCode,country,countryCode,region,regionName,city,district,zip,lat,lon,timezone,isp,org,as,asname,query",
            method = HttpMethod.Get,
        )
        resultFlow.collect { result ->
            emit(result) // Emit each result from the inner flow
        }
    }
}