package com.ip.locator.data.remote.response

import kotlinx.serialization.*

@Serializable
data class IPAddressResponse (
    val query: String = "",
    val status: String = "",
    val continent: String = "",
    val continentCode: String = "",
    val country: String = "",
    val countryCode: String = "",
    val region: String = "",
    val regionName: String = "",
    val city: String = "",
    val district: String = "",
    val zip: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val timezone: String = "",
    val offset: Long = 0,
    val currency: String = "",
    val isp: String = "",
    val org: String = "",

    @SerialName("as")
    val ipAddressResponseAs: String = "",

    @SerialName("asname")
    val asName: String = "",
    val mobile: Boolean = false,
    val proxy: Boolean = false,
    val hosting: Boolean = false
)