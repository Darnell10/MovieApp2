package com.example.d.movieapp2.dependency_injection

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: Application) {
    @Provides
    fun providesApplication(): Application = application
}