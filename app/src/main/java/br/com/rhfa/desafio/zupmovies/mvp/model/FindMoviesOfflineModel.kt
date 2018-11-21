package br.com.rhfa.desafio.zupmovies.mvp.model

import br.com.rhfa.desafio.zupmovies.domain.Movie

interface FindMoviesOfflineModel {
    fun getMovie(title: String): Movie?
    fun getMovies(title: String): List<Movie>?
    fun saveMovie(movie: Movie): Int
}
