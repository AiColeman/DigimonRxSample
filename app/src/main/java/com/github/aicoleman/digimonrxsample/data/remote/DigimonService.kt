package com.github.aicoleman.digimonrxsample.data.remote

import com.github.aicoleman.digimonrxsample.data.model.Digimon
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DigimonService {

    @GET("digimon")
    fun fetchDigimonList(

    ): Single<List<Digimon>>

    @GET("digimon/name/{name}")
    fun fetchDigimonInfo(
        @Path("name") name: String
    ): Single<List<Digimon>>

    @GET("digimon/level/{level}")
    fun fetchDigimonListByLevel(
        @Path("level") level: String
    ): Single<List<Digimon>>

    companion object {
        const val URL = "https://digimon-api.vercel.app/api/"
    }

}