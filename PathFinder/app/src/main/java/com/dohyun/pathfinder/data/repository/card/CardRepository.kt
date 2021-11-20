package com.dohyun.pathfinder.data.repository.card

import com.dohyun.pathfinder.data.model.Cards
import io.reactivex.rxjava3.core.Single

interface CardRepository {
    fun getList(): Single<List<Cards>>
}