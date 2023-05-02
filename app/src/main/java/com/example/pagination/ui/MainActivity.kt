package com.example.pagination.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagination.databinding.ActivityMainBinding
import com.example.pagination.ui.adapters.PassengerPagingAdapter
import com.example.pagination.ui.viewModels.PassengerViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.ViewModelLifecycle


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PassengerPagingAdapter
    private lateinit var passengerViewModel: PassengerViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        adapter = PassengerPagingAdapter()
        passengerViewModel = ViewModelProvider(this)[PassengerViewModel::class.java]

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        passengerViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })

    }
}