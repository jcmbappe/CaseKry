package com.example.casekry.modules

import com.example.casekry.data.AppDatabase
import com.example.casekry.repositories.ServicesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val roomRepositoryModule = module {

    single { AppDatabase.buildDatabase(androidContext()) }
    single { ServicesRepository(get(), get()) }
}