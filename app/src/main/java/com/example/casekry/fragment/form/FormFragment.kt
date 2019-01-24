package com.example.casekry.fragment.form


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.casekry.R
import com.example.casekry.databinding.FragmentFormBinding
import com.example.casekry.repositories.ServicesRepository
import com.example.casekry.utilities.runOnIoThread
import com.example.casekry.viewModels.BaseViewModel
import org.koin.android.ext.android.inject


/**
 * A simple [Fragment] subclass.
 *
 */
class FormFragment : Fragment() {
    private val servicesRepository: ServicesRepository by inject()
    private lateinit var viewModel: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = BaseViewModel.provideViewModel(
            this,
            BaseViewModel.Factory.get(this, servicesRepository),
            FormViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFormBinding.inflate(inflater, container, false).apply {
            viewModel = this@FormFragment.viewModel
            cancelButton.setOnClickListener {
                activity?.onBackPressed()
            }

            addButton.setOnClickListener {
                this@FormFragment.viewModel.validation {
                     this@FormFragment.activity?.runOnUiThread{
                        activity?.onBackPressed()
                    }
                }
            }
        }

        viewModel.callInProgress.observe(this, Observer {
            // Todo : Implement lottie animation
        })

        viewModel.nameError.observe(this, Observer {
            binding.textInputName.error = if (it) {
                getString(R.string.error_must_not_empty)
            } else {
                ""
            }
        })

        viewModel.urlError.observe(this, Observer {
            binding.textInputUrl.error = if (it) {
                getString(R.string.error_must_not_empty)
            } else {
                ""
            }
        })

        return binding.root
    }
}
