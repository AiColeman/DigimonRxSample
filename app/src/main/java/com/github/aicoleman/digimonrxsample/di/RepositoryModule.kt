package com.github.aicoleman.digimonrxsample.di

import com.github.aicoleman.digimonrxsample.data.remote.DigimonService
import com.github.aicoleman.digimonrxsample.repository.DigimonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @ExperimentalCoroutinesApi
    @Provides
    @ActivityRetainedScoped
    fun provideDigimonRepository(
        digimonService: DigimonService
    ): DigimonRepository {
        return DigimonRepository(digimonService)
    }
}