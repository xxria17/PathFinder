package com.dohyun.pathfinder.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface CardDao {

    @Query(value = "SELECT * FROM Cards")
    fun getList(): Single<List<Cards>>

    @Insert
    fun saveData(cards: Cards): Completable

    @Delete
    fun deleteData(cards: Cards): Completable

    @Query(value = "DELETE FROM cards")
    fun clear(): Completable
}