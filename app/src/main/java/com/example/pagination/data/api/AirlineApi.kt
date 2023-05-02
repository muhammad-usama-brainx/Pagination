package com.example.pagination.data.api

import com.example.pagination.data.models.Company
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AirlineApi {

    @GET("/v1/passenger")
    suspend fun getPassengers(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<Company>


}