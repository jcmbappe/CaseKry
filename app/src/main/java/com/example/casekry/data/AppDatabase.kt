package com.example.casekry.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.casekry.dao.ServicesDao
import com.example.casekry.data.entities.Service

@Database(entities = [Service::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun servicesDao(): ServicesDao

    companion object {
        private const val DATABASE_NAME = "case_kry-db"

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}