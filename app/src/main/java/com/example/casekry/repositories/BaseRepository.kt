package com.example.casekry.repositories

import androidx.lifecycle.LiveData
import com.example.casekry.dao.DoaInterface
import com.example.casekry.data.entities.DataEntity
import com.example.casekry.modules.NetworkCallback
import com.example.casekry.utilities.runOnIoThread
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

abstract class BaseRepository<ENTITY : DataEntity>(
    private val okHttpClient: OkHttpClient,
    private val dao: DoaInterface<ENTITY>
) {

    fun getEntities(): LiveData<List<ENTITY>> = dao.getEntities()

    fun getEntity(id: Long): LiveData<ENTITY> = dao.getEntity(id)

    fun insertEntity(entity: ENTITY) = runOnIoThread {
        dao.insertEntity(entity)
    }

    fun updateEntity(entity: ENTITY) = runOnIoThread {
        dao.updateEntity(entity)
    }

    fun deleteEntity(entity: ENTITY) = runOnIoThread {
        dao.deleteEntity(entity)
    }

    fun get(url: String, callback: NetworkCallback) = okHttpClient.newCall(
        Request.Builder()
            .url(
                HttpUrl.parse(url)
                    ?.newBuilder()
                    ?.build().toString()
            )
            .build()
    ).enqueue(callback)
}