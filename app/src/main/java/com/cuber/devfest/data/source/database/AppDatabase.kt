package com.cuber.devfest.data.source.database

import android.arch.persistence.room.RoomDatabase
import com.cuber.devfest.data.source.database.dao.ProductDao

abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}