package com.example.casekry

import android.app.Application
import com.example.casekry.modules.networkModule
import com.example.casekry.modules.roomRepositoryModule
import org.koin.android.ext.android.startKoin

class CaseKryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, arrayListOf(networkModule, roomRepositoryModule))
    }
}