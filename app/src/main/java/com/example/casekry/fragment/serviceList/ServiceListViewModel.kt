package com.example.casekry.fragment.serviceList

import android.app.Application
import com.example.casekry.data.entities.Service
import com.example.casekry.repositories.ServicesRepository
import com.example.casekry.viewModels.BaseViewModel

class ServiceListViewModel(application: Application, servicesRepository: ServicesRepository) :
    BaseViewModel<Service>(application, servicesRepository) {

    fun getServicesList() = repository.getEntities()
}