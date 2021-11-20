package com.dohyun.pathfinder.data.repository.card

import android.content.Context
import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CardRepository {
    fun decodeData(context: Context): Single<List<Cards>>
    fun saveData(cards: Cards): Completable
    fun getList(): Single<List<Cards>>
}