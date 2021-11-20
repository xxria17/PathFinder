package com.dohyun.pathfinder.view.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dohyun.pathfinder.data.model.Cards
import com.dohyun.pathfinder.data.repository.card.CardRepository
import com.dohyun.pathfinder.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val repository: CardRepository
): BaseViewModel() {

    private val _result = MutableLiveData<List<Cards>>()
    val result : LiveData<List<Cards>>
        get() = _result

    fun getData() {
        repository.getList()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _result.postValue(it)
            }, {
                println("CardViewModel getData error ${it.message}")
            })
    }

}