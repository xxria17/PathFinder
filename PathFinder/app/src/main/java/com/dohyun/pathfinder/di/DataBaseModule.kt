package com.dohyun.pathfinder.di

import android.app.Application
import androidx.room.Room
import com.dohyun.pathfinder.data.local.AppDatabase
import com.dohyun.pathfinder.data.local.AppDatabase.Companion.DB_NAME
import com.dohyun.pathfinder.data.local.CardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideCards(appDatabase: AppDatabase): CardDao =
        appDatabase.cardDao()
}