package com.example.casekry.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.casekry.data.entities.Service

/**
 * The Data Access Object for the Location class.
 */
@Dao
interface ServicesDao : DoaInterface<Service> {
    @Query("SELECT * FROM ${Service.TABLE_NAME} ORDER BY ${Service.COLUMN_ID}")
    override fun getEntities(): LiveData<List<Service>>

    @Query("SELECT * FROM ${Service.TABLE_NAME} WHERE ${Service.COLUMN_ID} = :id")
    override fun getEntity(id: Long): LiveData<Service>
}