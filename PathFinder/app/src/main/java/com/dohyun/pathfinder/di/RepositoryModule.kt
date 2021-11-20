package com.dohyun.pathfinder.di

import com.dohyun.pathfinder.data.repository.card.CardRepository
import com.dohyun.pathfinder.data.repository.card.CardRepositoryImpl
import com.dohyun.pathfinder.data.repository.edit.EditRepository
import com.dohyun.pathfinder.data.repository.edit.EditRepositoryImpl
import com.dohyun.pathfinder.data.repository.main.MainRepository
import com.dohyun.pathfinder.data.repository.main.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsCardRepository(
        repositoryImpl: CardRepositoryImpl
    ): CardRepository

    @Binds
    abstract fun bindsEditRepository(
        repositoryImpl: EditRepositoryImpl
    ): EditRepository

    @Binds
    abstract fun bindsMainRepository(
            repositoryImpl: MainRepositoryImpl
    ): MainRepository
}