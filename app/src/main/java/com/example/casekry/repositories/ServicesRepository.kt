package com.example.casekry.repositories

import com.example.casekry.data.AppDatabase
import com.example.casekry.data.entities.Service
import okhttp3.OkHttpClient

class ServicesRepository(okHttpClientClient: OkHttpClient, appDatabase: AppDatabase) :
    BaseRepository<Service>(okHttpClientClient, appDatabase.servicesDao())