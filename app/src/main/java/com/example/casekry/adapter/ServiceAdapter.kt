package com.example.casekry.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.casekry.data.entities.Service
import com.example.casekry.databinding.ViewHolderServiceBinding
import com.example.casekry.viewHolder.service.ServiceViewHolder

class ServiceAdapter : RecyclerView.Adapter<ServiceViewHolder>() {

    var list: List<Service> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(
            ViewHolderServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) = holder.bind(list[position])
}