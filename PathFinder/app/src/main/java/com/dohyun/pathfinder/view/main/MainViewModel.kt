package com.dohyun.pathfinder.view.main

import com.dohyun.pathfinder.data.repository.main.MainRepository
import com.dohyun.pathfinder.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): BaseViewModel() {

    fun clear() {
        repository.clearAll()
                .subscribeOn(Schedulers.io())
                .doOnError {
                    println("MainViewModel clear error ${it.message}")
                }
    }
}