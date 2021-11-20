package com.dohyun.pathfinder.view.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dohyun.pathfinder.data.model.Cards
import com.dohyun.pathfinder.data.repository.edit.EditRepository
import com.dohyun.pathfinder.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
        private val repository: EditRepository
) : BaseViewModel() {

    private val _result = MutableLiveData<List<Cards>>()
    val result: LiveData<List<Cards>>
        get() = _result

    fun getLists() {
        compositeDisposable.add(
                repository.getLists()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            _result.postValue(it)
                        }, {
                            println("EditViewModel error ${it.message}")
                        })
        )
    }

    fun saveChanges(list: MutableList<Cards>) {
        for (i in list) {
            repository.saveChanges(i)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError {
                        println("EditViewModel saveChanges error ${it.message}")
                    }
        }
    }
}