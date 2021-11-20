package com.dohyun.pathfinder.data.repository.edit

import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface EditRepository {
    fun getLists(): Single<List<Cards>>
    fun deleteItems(card: Cards): Completable
    fun saveChanges(cards: Cards): Completable
}