package com.dohyun.pathfinder.data.repository.card

import com.dohyun.pathfinder.data.local.CardDao
import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardDao: CardDao
): CardRepository {
    override fun getList(): Single<List<Cards>> {
        return Single.just(cardDao.getList())
    }
}