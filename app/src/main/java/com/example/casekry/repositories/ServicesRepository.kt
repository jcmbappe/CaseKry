package com.example.casekry.repositories

import androidx.lifecycle.LiveData
import com.example.casekry.dao.ServicesDao
import com.example.casekry.data.AppDatabase
import com.example.casekry.data.entities.Service
import com.example.casekry.utilities.runOnIoThread

class ServicesRepository(appDatabase: AppDatabase) : BaseRepository<Service> {
    private val servicesDao: ServicesDao = appDatabase.servicesDao()

    override fun getEntities(): LiveData<List<Service>> = servicesDao.getEntities()

    override fun getEntity(id: Long): LiveData<Service> = servicesDao.getEntity(id)

    override fun insertEntity(entity: Service) {
        runOnIoThread {
            servicesDao.insertEntity(entity)
        }
    }

    override fun updateEntity(entity: Service) {
        runOnIoThread {
            servicesDao.updateEntity(entity)
        }
    }

    override fun deleteEntity(entity: Service) {
        runOnIoThread {
            servicesDao.deleteEntity(entity)
        }
    }
}