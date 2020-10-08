package com.github.aicoleman.digimonrxsample.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.aicoleman.digimonrxsample.data.model.Digimon
import com.github.aicoleman.digimonrxsample.repository.DigimonRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class DigimonViewModel @ViewModelInject constructor(
    val digimonRepository: DigimonRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _digimonListLiveData = MutableLiveData<List<Digimon>>()

    val digimonListLiveData: LiveData<List<Digimon>>
        get() = _digimonListLiveData

    fun getDigimonList() {
        compositeDisposable.add(
            digimonRepository.getDigimonList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _digimonListLiveData.postValue(it)
                    },
                    {
                        Log.d("Digimon ViewModel", ":"+it.message)
                    }
                )
        )
    }
}