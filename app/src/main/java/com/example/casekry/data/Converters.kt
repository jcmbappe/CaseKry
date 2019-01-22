package com.example.casekry.data

import androidx.room.TypeConverter
import com.example.casekry.data.entities.ServiceStatus

class Converters {
    @TypeConverter
    fun serviceStatusToInt(value: ServiceStatus): Int = value.ordinal

    @TypeConverter
    fun intToServiceStatus(value: Int): ServiceStatus = ServiceStatus.values()[value]
}