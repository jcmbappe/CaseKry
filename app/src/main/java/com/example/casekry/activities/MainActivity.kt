package com.example.casekry.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.casekry.R
import com.example.casekry.databinding.ActivityMainBinding
import com.example.casekry.fragment.serviceList.ServiceListFragment

class MainActivity : AppCompatActivity(), ServiceListFragment.Interaction {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, ServiceListFragment())
            commit()
        }
    }

    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            addToBackStack(fragment.tag)


            replace(R.id.container, fragment, fragment.tag)
            commit()
        }
    }
}
