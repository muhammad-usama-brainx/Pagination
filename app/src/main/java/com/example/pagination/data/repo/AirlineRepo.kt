package com.example.pagination.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagination.data.api.AirlineApi
import com.example.pagination.data.paging.AirlinePagingSource
import javax.inject.Inject

class AirlineRepo @Inject constructor(private val airlineApi: AirlineApi) {

    fun getPassengers() = Pager(
        config = PagingConfig(maxSize = 100, pageSize = 10),
        pagingSourceFactory = { AirlinePagingSource(airlineApi) }
    ).liveData
}