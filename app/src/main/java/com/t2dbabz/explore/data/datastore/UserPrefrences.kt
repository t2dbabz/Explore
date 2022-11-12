package com.t2dbabz.explore.data.datastore

import kotlinx.coroutines.flow.Flow

interface UserPreferences {
    val isAppThemeDarkMode: Flow<Boolean?>
    suspend fun updateAppTheme(darkMode: Boolean)
}