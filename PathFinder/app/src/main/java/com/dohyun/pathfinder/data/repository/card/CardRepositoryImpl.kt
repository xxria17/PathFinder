package com.dohyun.pathfinder.data.repository.card

import android.content.Context
import com.dohyun.pathfinder.data.local.CardDao
import com.dohyun.pathfinder.data.model.Cards
import com.dohyun.pathfinder.data.remote.JsonParser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardDao: CardDao
): CardRepository {
    override fun getList(): Single<List<Cards>> {
        return cardDao.getList()
    }

    override fun decodeData(context: Context): Single<List<Cards>> {
        return Single.just(JsonParser.getJSONData(context))
    }

    override fun saveData(cards: Cards): Completable {
        return cardDao.saveData(cards)
    }
}