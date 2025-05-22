package com.ydnsa.koinmvi.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")
class DataStoreManager(private val context: Context) {

    companion object{
        private val nameKey= stringPreferencesKey("first_name")
    }
   suspend fun saveName(name: String){
        context.dataStore.edit { pref ->
        pref[nameKey] =name
            Log.d("Pref",pref[nameKey]?:"Default")
        }
    }

    val nameFlow : Flow<String> =context.dataStore.data.map { it -> it[nameKey]?:"default" }
}