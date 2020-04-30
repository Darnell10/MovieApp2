package com.example.d.movieapp2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.d.movieapp2.dependency_injection.CONTEXT_APP
import com.example.d.movieapp2.dependency_injection.DaggerViewModelComponent
import com.example.d.movieapp2.dependency_injection.TypeOfContext
import com.example.d.movieapp2.models.MovieApiService
import com.example.d.movieapp2.models.MovieModel
import com.example.d.movieapp2.util.SharedPreferenceHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ViewModel(application: Application) : AndroidViewModel(application) {

    val movies by lazy { MutableLiveData<List<MovieModel>>() }
    val loaderError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    @Inject
    lateinit var movieApiService: MovieApiService

    @Inject
    @field:TypeOfContext(CONTEXT_APP)
    lateinit var prefs: SharedPreferenceHelper
    private var injected = false

    fun inject(){


        }



}