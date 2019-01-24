package com.example.casekry.fragment.serviceList


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.casekry.adapter.ServiceAdapter
import com.example.casekry.databinding.FragmentServiceListBinding
import com.example.casekry.fragment.form.FormFragment
import com.example.casekry.repositories.ServicesRepository
import com.example.casekry.viewModels.BaseViewModel
import org.koin.android.ext.android.inject

class ServiceListFragment : Fragment() {
    private val servicesRepository: ServicesRepository by inject()
    private lateinit var viewModel: ServiceListViewModel

    private var interaction: Interaction? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Interaction) {
            interaction = context
        } else {
            throw Exception("Context must implement ${Interaction::class.java.simpleName}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = BaseViewModel.provideViewModel(
            this,
            BaseViewModel.Factory.get(this, servicesRepository),
            ServiceListViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentServiceListBinding.inflate(inflater, null, false).apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        val adapter = ServiceAdapter().apply {
            binding.recyclerView.adapter = this
        }

        binding.fab.setOnClickListener {
            interaction?.replaceFragment(FormFragment())
        }

        viewModel.getServicesList().observe(this, Observer { list ->
            list?.let { adapter.list = it }
        })

        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        interaction = null
    }

    interface Interaction {
        fun replaceFragment(fragment: Fragment)
    }
}
