package com.example.casekry.fragment.form

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.casekry.data.entities.Service
import com.example.casekry.data.entities.ServiceStatus
import com.example.casekry.modules.NetworkCallback
import com.example.casekry.repositories.BaseRepository
import com.example.casekry.utilities.KotlinTools
import com.example.casekry.viewModels.BaseViewModel

class FormViewModel(application: Application, repository: BaseRepository<Service>) :
    BaseViewModel<Service>(application, repository) {

    val name = ObservableField<String>()
    val url = ObservableField<String>()

    val nameError = MutableLiveData<Boolean>()
    val urlError = MutableLiveData<Boolean>()

    val callInProgress = MutableLiveData<Boolean>()

    fun validation(callCompleteCallBack: () -> Unit) {
        nameError.value = name.get().isNullOrEmpty()
        urlError.value = url.get().isNullOrEmpty()

        KotlinTools.let(name.get(), url.get()) { name, url ->
            callInProgress.value = true

            val formatUrl = "https://${url.trim()}"
            repository.get(formatUrl, object : NetworkCallback(callInProgress) {
                override fun onSuccess() {
                    repository.insertEntity(Service(name.trim(), formatUrl, ServiceStatus.OK))
                }

                override fun onUnsuccessful() {
                    repository.insertEntity(Service(name.trim(), formatUrl, ServiceStatus.FAIL))
                }

                override fun onComplete() {
                    super.onComplete()
                    callCompleteCallBack.invoke()
                }
            })
        }
    }
}