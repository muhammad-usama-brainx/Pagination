package com.example.pagination.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagination.data.api.AirlineApi
import com.example.pagination.data.models.Airline
import com.example.pagination.data.models.Company
import com.example.pagination.data.models.Passenger

class AirlinePagingSource(private val airlineApi: AirlineApi) : PagingSource<Int, Passenger>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Passenger> {
        return try {
            val position = params.key ?: 1
            println(position)
            val response = airlineApi.getPassengers(position, 10)
            println(response.isSuccessful)
            println(response.body())

            LoadResult.Page(
                data = response.body()!!.data,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (position == response.body()!!.totalPages) null else position + 1
            )
        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Passenger>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }


}