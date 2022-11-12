package com.t2dbabz.explore.di

import com.t2dbabz.explore.data.datastore.UserPreferences
import com.t2dbabz.explore.data.datastore.UserPreferencesImplDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindUserPreferences(
        userPreferences: UserPreferencesImplDataStore
    ): UserPreferences
}