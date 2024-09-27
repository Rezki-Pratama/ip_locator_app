package com.ip.locator.domain.usecase

import com.ip.locator.domain.repository.IRepository

class Interactor(private val repository: IRepository): UseCase {
    override fun searchIpAddress(query: String)  = repository.searchIpAddress(query)
}