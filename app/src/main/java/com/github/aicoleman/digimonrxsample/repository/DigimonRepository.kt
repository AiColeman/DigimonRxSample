package com.github.aicoleman.digimonrxsample.repository

import com.github.aicoleman.digimonrxsample.data.model.Digimon
import com.github.aicoleman.digimonrxsample.data.remote.DigimonService
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class DigimonRepository @Inject constructor(
    private val digimonService: DigimonService
) {
    fun getDigimonList(): Single<List<Digimon>> {
        return digimonService.fetchDigimonList()
    }

}