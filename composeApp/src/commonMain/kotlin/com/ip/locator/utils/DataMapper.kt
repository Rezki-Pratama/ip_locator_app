package com.ip.locator.utils

import com.ip.locator.data.remote.response.IPAddressResponse
import com.ip.locator.domain.model.IPAddress

fun mapIpAddressResponseToApiAddress(response: IPAddressResponse): IPAddress {
    return IPAddress(
        query = response.query,
        status = response.status,
        continent = response.continent,
        continentCode = response.continentCode,
        country = response.country,
        countryCode = response.countryCode,
        region = response.region,
        regionName = response.regionName,
        city = response.city,
        district = response.district,
        zip = response.zip,
        latitude = response.lat,
        longitude = response.lon,
        timezone = response.timezone,
        offset = response.offset,
        currency = response.currency,
        isp = response.isp,
        organization = response.org,
        ipAddressAs = response.ipAddressResponseAs,
        asName = response.asName,
        isMobile = response.mobile,
        isProxy = response.proxy,
        isHosting = response.hosting
    )
}