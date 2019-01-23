package com.example.casekry.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.casekry.databinding.ActivityMainBinding
import com.example.casekry.fragment.serviceList.ServiceListFragment
import com.example.casekry.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)?.apply {
            replaceFragment(ServiceListFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, fragment.tag)
                .commit()

            return true
        }
 }
