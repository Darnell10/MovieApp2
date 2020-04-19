package com.example.d.movieapp2.dependency_injection

import com.example.d.movieapp2.viewmodel.ViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ViewModelComponent {
    fun inject(viewModel: ViewModel)
}