package com.example.casekry.fragment.form

import android.app.Application
import androidx.databinding.ObservableField
import com.example.casekry.data.entities.Service
import com.example.casekry.repositories.BaseRepository
import com.example.casekry.viewModels.BaseViewModel

class FormViewModel(application: Application, repository: BaseRepository<Service>) :
    BaseViewModel<Service>(application, repository) {

    val name = ObservableField<String>()
    val url = ObservableField<String>()
}