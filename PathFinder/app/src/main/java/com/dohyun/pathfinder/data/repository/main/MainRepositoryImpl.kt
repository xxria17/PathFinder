package com.dohyun.pathfinder.data.repository.main

import com.dohyun.pathfinder.data.local.CardDao
import com.dohyun.pathfinder.data.model.Cards
import com.dohyun.pathfinder.data.remote.JsonParser
import com.dohyun.pathfinder.data.remote.JsonReader
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val cardDao: CardDao
): MainRepository {

    private val dataUrl = "https://storage.googleapis.com/mobile_example/data/items.json"

    override fun decodeData(): Single<List<Cards>> {
        return Single.just(JsonReader.parseDataList(JsonParser.getJSONFromUrl(dataUrl)))
    }

    override fun saveData(cards: Cards): Completable {
        return cardDao.saveData(cards)
    }

}