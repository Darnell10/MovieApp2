package com.example.d.movieapp2.dependency_injection

import android.app.Application
import com.example.d.movieapp2.util.SharedPreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
open class PrefsModule {
    @Provides
    @Singleton
    @TypeOfContext(CONTEXT_APP)
    open fun providesSharedPreferences(application: Application): SharedPreferenceHelper {
        return SharedPreferenceHelper(application)

    }

}

const val CONTEXT_APP = "Application Context"

@Qualifier
annotation class TypeOfContext(val type: String)