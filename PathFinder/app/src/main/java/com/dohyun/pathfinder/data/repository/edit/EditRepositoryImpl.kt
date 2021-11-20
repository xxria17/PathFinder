package com.dohyun.pathfinder.data.repository.edit

import com.dohyun.pathfinder.data.local.CardDao
import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class EditRepositoryImpl @Inject constructor(
    private val cardDao: CardDao
): EditRepository {
    override fun getLists(): Single<List<Cards>> {
        return cardDao.getList()
    }

    override fun deleteItems(card: Cards): Completable {
        return cardDao.deleteData(card)
    }

    override fun saveChanges(cards: Cards): Completable {
        return cardDao.saveData(cards)
    }
}