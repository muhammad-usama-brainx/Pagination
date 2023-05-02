package com.example.pagination.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagination.R
import com.example.pagination.data.models.Passenger

class PassengerPagingAdapter :
    PagingDataAdapter<Passenger, PassengerPagingAdapter.PassengerViewHolder>(COMPARATOR) {

    class PassengerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById<TextView>(R.id.nameTv)
        val trips: TextView = itemView.findViewById(R.id.tripsTv)
    }

    override fun onBindViewHolder(holder: PassengerViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.name.text = item.name
            holder.trips.text = item.trips.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_passenger, parent, false)
        return PassengerViewHolder(view)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Passenger>() {
            override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
                return oldItem == newItem
            }

        }
    }
}