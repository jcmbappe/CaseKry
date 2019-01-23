package com.example.casekry.repositories

import androidx.lifecycle.LiveData
import com.example.casekry.data.entities.DataEntity

interface BaseRepository<ENTITY : DataEntity> {

    fun getEntities(): LiveData<List<ENTITY>>

    fun getEntity(id: Long): LiveData<ENTITY>

    fun insertEntity(entity: ENTITY)

    fun updateEntity(entity: ENTITY)

    fun deleteEntity(entity: ENTITY)
}