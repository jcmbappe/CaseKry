package com.example.casekry.data.entities

import com.example.casekry.R

enum class ServiceStatus {
    OK {
        override fun getColorRes(): Int= R.color.nephritis
        override fun getStringRes(): Int = R.string.status_ok
    },
    FAIL {
        override fun getColorRes(): Int= R.color.pomegrenate
        override fun getStringRes(): Int = R.string.status_fail
    };

    abstract fun getStringRes(): Int
    abstract fun getColorRes(): Int
}