package com.example.casekry.viewHolder.service

import androidx.databinding.ObservableField

class ServiceViewModel {
    val name = ObservableField<String>()
    val status = ObservableField<String>()
    val url = ObservableField<String>()
    val color = ObservableField<Int>()
}