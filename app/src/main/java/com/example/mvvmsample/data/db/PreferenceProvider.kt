package com.example.mvvmsample.data.db

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

private const val KEY_SAVED_AT = "key_saved_at"
class PreferenceProvider(
    private val context: Context
) {
    private val appContext = context.applicationContext
    private val preferences : SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun savelastSavedAt(savedAt : String){
        preferences.edit().putString(
            KEY_SAVED_AT,
            savedAt)
            .apply()
    }

    fun getlastSavedAt() : String?{
        return preferences.getString(KEY_SAVED_AT, null)
    }


}