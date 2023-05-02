package com.example.pagination.di

import com.example.pagination.data.api.AirlineApi
import com.example.pagination.data.repo.AirlineRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getAirlineApi(): AirlineApi = Retrofit.Builder()
        .baseUrl("https://api.instantwebtools.net")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AirlineApi::class.java)

    @Provides
    @Singleton
    fun getAirlineRepo(airlineApi: AirlineApi): AirlineRepo = AirlineRepo(airlineApi)

}