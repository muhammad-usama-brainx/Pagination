package com.example.pagination.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagination.data.repo.AirlineRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PassengerViewModel @Inject constructor(private val airlineRepo: AirlineRepo) : ViewModel() {
    val list = airlineRepo.getPassengers().cachedIn(viewModelScope)
}