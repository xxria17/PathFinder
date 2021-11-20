package com.dohyun.pathfinder.data.repository.main

import com.dohyun.pathfinder.data.local.CardDao
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
        private val cardDao: CardDao
): MainRepository {
    override fun clearAll(): Completable {
        return cardDao.clear()
    }
}