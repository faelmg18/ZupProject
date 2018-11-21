package br.com.rhfa.desafio.zupmovies.mvp.presenter

import android.os.Bundle
import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter

interface MoviesPresenter : BasePresenter {

    fun findMove(savedInstanceState: Bundle?, title: String)

    fun onFindMove(movie: Movie)

    fun saveMove(movie: Movie)

}
