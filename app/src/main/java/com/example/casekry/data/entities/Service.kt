package com.example.casekry.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Service.TABLE_NAME)
data class Service(
    @ColumnInfo(name = COLUMN_NAME)
    var name: String,
    @ColumnInfo(name = COLUMN_URL)
    var url: String
) : DataEntity() {

    companion object {
        const val TABLE_NAME = "services"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_URL = "url"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Service.COLUMN_ID)
    var id: Long = 0
}