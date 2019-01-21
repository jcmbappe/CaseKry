package com.example.casekry.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.casekry.R
import com.example.casekry.databinding.FragmentServiceListBinding

class ServiceListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentServiceListBinding.inflate(inflater, null, false).root
    }
}
