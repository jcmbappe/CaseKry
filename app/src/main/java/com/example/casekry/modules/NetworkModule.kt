package com.example.casekry.modules

import okhttp3.OkHttpClient
import org.koin.dsl.module.module

val networkModule = module {
    single { OkHttpClient() }
}