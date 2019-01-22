package com.example.casekry.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.casekry.data.entities.DataEntity

interface DoaInterface<ENTITY : DataEntity> {

    fun getEntities(): LiveData<List<ENTITY>>

    fun getEntity(id: Long): LiveData<ENTITY>

    @Insert
    fun insertEntity(entity: ENTITY): Long

    @Update
    fun updateEntity(entity: ENTITY)

    @Delete
    fun deleteEntity(entity: ENTITY)
}