package com.dohyun.pathfinder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dohyun.pathfinder.data.model.Cards

@Database(entities = [Cards::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cardDao(): CardDao

    companion object {
        const val DB_NAME = "database-pathfinder"
    }
}