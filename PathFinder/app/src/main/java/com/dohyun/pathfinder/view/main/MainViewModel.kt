package com.dohyun.pathfinder.view.main

import com.dohyun.pathfinder.data.repository.main.MainRepository
import com.dohyun.pathfinder.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): BaseViewModel() {

    fun getDataFromUrl() {
        compositeDisposable.add(
            repository.decodeData()
                .observeOn(Schedulers.io())
                .subscribe({
                    for (i in it) {
                        repository.saveData(i)
                            .observeOn(Schedulers.io())
                            .subscribe({
                                println("MainViewModel saveData Success!!")
                            }, { error ->
                                println("MainViewModel saveData error ${error.message}")
                            })
                    }
                }, {
                    println("MainViewModel getData error ${it.message}")
                })
        )
    }
}