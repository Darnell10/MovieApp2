package com.example.d.movieapp2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.d.movieapp2.R
import com.example.d.movieapp2.databinding.ItemLayoutBinding
import com.example.d.movieapp2.models.MovieModel
import com.example.d.movieapp2.util.MovieClickListener

class MovieAdapter(private val movieList: ArrayList<MovieModel>) :
        RecyclerView.Adapter<MovieAdapter.MovieHolder>(), MovieClickListener {

    fun updateMovieList(newMovieList: List<MovieModel>) {
        movieList.clear()
        movieList.addAll(newMovieList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: ItemLayoutBinding =
                DataBindingUtil.inflate<ItemLayoutBinding>(inflater, R.layout.item_layout, parent
                        , false)
        return MovieHolder(view)

    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.view.movie = movieList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int = movieList.size


    override fun onClick(view: View) {
        for (movie: MovieModel in movieList) {
            if (view.tag == movie.title) {
                val action =
                        MovieListFragmentDirections.actionMovieListFragmentToDetailFragment(movie)
                Navigation.findNavController(view).navigate(action)
            }

        }
    }


    class MovieHolder(var view: ItemLayoutBinding) : RecyclerView.ViewHolder(view.root)

}