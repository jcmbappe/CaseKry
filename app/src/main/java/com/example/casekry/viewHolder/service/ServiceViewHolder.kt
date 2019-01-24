package com.example.casekry.viewHolder.service

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.casekry.data.entities.Service
import com.example.casekry.databinding.ViewHolderServiceBinding

class ServiceViewHolder(binding: ViewHolderServiceBinding) : RecyclerView.ViewHolder(binding.root) {

    private val context: Context = binding.root.context
    private val viewModel: ServiceViewModel = ServiceViewModel()

    init {
        binding.viewModel = viewModel
    }

    fun bind(service : Service) {
        viewModel.apply {
            name.set(service.name)
            status.set(context.getString(service.status.getStringRes()))
            color.set(ContextCompat.getColor(context, service.status.getColorRes()))
            url.set(service.url)
        }
    }
}