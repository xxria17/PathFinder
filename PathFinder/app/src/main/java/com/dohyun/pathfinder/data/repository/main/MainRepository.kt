package com.dohyun.pathfinder.data.repository.main

import io.reactivex.rxjava3.core.Completable

interface MainRepository {
    fun clearAll(): Completable
}