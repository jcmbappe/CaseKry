package com.example.casekry.fragment.serviceList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.casekry.adapter.ServiceAdapter
import com.example.casekry.data.entities.Service
import com.example.casekry.databinding.FragmentServiceListBinding
import com.example.casekry.repositories.ServicesRepository
import com.example.casekry.viewModels.BaseViewModel
import org.koin.android.ext.android.inject

class ServiceListFragment : Fragment() {
    private val servicesRepository : ServicesRepository by inject()
    private lateinit var viewModel : ServiceListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = BaseViewModel.provideViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentServiceListBinding.inflate(inflater, null, false).apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        val adapter = ServiceAdapter().apply {
            binding.recyclerView.adapter = this
        }

        viewModel.getServicesList().observe(this, Observer {list ->
            list?.let { adapter.list = it }
        })

        return  binding.root
    }
}
