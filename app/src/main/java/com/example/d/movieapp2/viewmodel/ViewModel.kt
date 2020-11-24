package com.example.d.movieapp2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.d.movieapp2.api.MovieApiService
import com.example.d.movieapp2.models.MovieModel
import io.reactivex.disposables.CompositeDisposable


class ViewModel(application: Application) : AndroidViewModel(application) {

    val movies by lazy { MutableLiveData<List<MovieModel>>() }
    val loaderError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    private val disposable = CompositeDisposable()

    lateinit var movieApiService: MovieApiService




}