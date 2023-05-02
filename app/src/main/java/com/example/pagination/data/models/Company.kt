package com.example.pagination.data.models

data class Company(
    val data: List<Passenger>,
    val totalPages: Int,
    val totalPassengers: Int
)