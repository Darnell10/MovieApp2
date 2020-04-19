package com.example.d.movieapp2.dependency_injection

import com.example.d.movieapp2.models.MovieApiService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: MovieApiService)
}