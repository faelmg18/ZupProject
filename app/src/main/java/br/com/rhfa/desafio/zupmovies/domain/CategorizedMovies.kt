package br.com.rhfa.desafio.zupmovies.domain

import java.util.ArrayList

class CategorizedMovies(private val movies: ArrayList<Movie>?, private val genre: String) {

    fun getGenre(): String? = this.genre

    fun setGenre(genre: String) {
        var genre = genre
        genre = genre
    }

    fun getMovies(): ArrayList<Movie>? = movies
    fun setMovies(movies: ArrayList<Movie>) {
        var movies = movies
        movies = movies
    }
}
