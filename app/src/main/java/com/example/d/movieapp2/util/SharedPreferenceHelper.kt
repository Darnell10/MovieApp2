package com.example.d.movieapp2.util

import android.content.Context
import androidx.preference.PreferenceManager

class SharedPreferenceHelper(context: Context) {

    private val PREF_KEY = "Api key"

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context.applicationContext)


}