package com.ip.locator.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class IPAddress(
    val query: String,
    val status: String,
    val continent: String,
    val continentCode: String,
    val country: String,
    val countryCode: String,
    val region: String,
    val regionName: String,
    val city: String,
    val district: String,
    val zip: String,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val offset: Long,
    val currency: String,
    val isp: String,
    val organization: String,
    val ipAddressAs: String,
    val asName: String,
    val isMobile: Boolean,
    val isProxy: Boolean,
    val isHosting: Boolean
) {
    companion object {
         val empty = IPAddress(
         query = "",
         status = "",
         continent = "",
         continentCode = "",
         country = "",
         countryCode = "",
         region = "",
         regionName = "",
         city = "",
         district = "",
         zip = "",
         latitude = 0.0,
         longitude = 0.0,
         timezone = "",
         offset = 0,
         currency = "",
         isp = "",
         organization = "",
         ipAddressAs = "",
         asName = "",
         isMobile = false,
         isProxy = false,
         isHosting = false
        )
    }
}