package com.example.weathermobileapp.common

interface ApiMapper<dto, domain> {
    fun mapToDomain(dto: dto): domain
}