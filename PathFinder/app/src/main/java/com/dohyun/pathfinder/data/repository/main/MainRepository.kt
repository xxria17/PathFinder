package com.dohyun.pathfinder.data.repository.main

import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface MainRepository {
    fun decodeData(): Single<List<Cards>>
    fun saveData(cards: Cards): Completable
}