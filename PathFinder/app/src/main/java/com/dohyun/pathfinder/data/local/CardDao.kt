package com.dohyun.pathfinder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Completable

@Dao
interface CardDao {

    @Query(value = "SELECT * FROM Cards")
    fun getList(): List<Cards>

    @Insert
    fun saveData(cards: Cards): Completable
}