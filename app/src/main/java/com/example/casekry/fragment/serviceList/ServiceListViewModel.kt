package com.example.casekry.fragment.serviceList

import android.app.Application
import android.os.Handler
import com.example.casekry.data.entities.Service
import com.example.casekry.data.entities.ServiceStatus
import com.example.casekry.modules.NetworkCallback
import com.example.casekry.repositories.BaseRepository
import com.example.casekry.viewModels.BaseViewModel

class ServiceListViewModel(application: Application, servicesRepository: BaseRepository<Service>) :
    BaseViewModel<Service>(application, servicesRepository) {

    val servicesList = repository.getEntities()

    private val handler = Handler()
    private val task = object : Runnable {
        override fun run() {
            runUpdate()
            handler.postDelayed(this, INTERVAL)
        }
    }

    companion object {
        private const val INTERVAL: Long = 1000 * 60 * 1
    }

    init {
        task.run()
    }


    fun runUpdate() {
        servicesList.value?.forEach { service ->
            repository.get(service.url, object : NetworkCallback() {
                override fun onSuccess() {
                    service.status = ServiceStatus.OK
                }

                override fun onUnsuccessful() {
                    service.status = ServiceStatus.FAIL
                }

                override fun onComplete() {
                    super.onComplete()

                    repository.updateEntity(service)
                }
            })
        }
    }
}