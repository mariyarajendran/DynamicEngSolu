package com.task.data.local

import android.content.Context
import com.google.gson.GsonBuilder
import com.task.*
import com.task.data.dto.login.LoginResponse
import javax.inject.Inject

class LocalData @Inject constructor(val context: Context) {
    fun putLoginResponseData(loginResponse: LoginResponse) {
        val sharedPref = context.getSharedPreferences(PREF_PREFERENCES_FILE_NAME, 0)
        //Convert object to JSON String.
        val jsonString = GsonBuilder().create().toJson(loginResponse)
        //Save that String in SharedPreferences
        sharedPref.edit().putString(PREF_LOGIN_DATA_KEY, jsonString).apply()
    }

    fun getLoginResponseData(): LoginResponse {
        val sharedPref = context.getSharedPreferences(PREF_PREFERENCES_FILE_NAME, 0)
        //We read JSON String which was saved.
        val value = sharedPref.getString(PREF_LOGIN_DATA_KEY, null)
        return GsonBuilder().create().fromJson(value, LoginResponse::class.java)
    }

    fun getLoginSession(): Boolean {
        val sharedPref = context.getSharedPreferences(PREF_PREFERENCES_FILE_NAME, 0)
        val value: Boolean = sharedPref.getBoolean(PREF_IS_LOGIN_KEY, false)
        return value
    }

    fun putLoginSession(status: Boolean) {
        val sharedPref = context.getSharedPreferences(PREF_PREFERENCES_FILE_NAME, 0)
        sharedPref.edit().putBoolean(PREF_IS_LOGIN_KEY, status).apply()
    }
}

