package br.com.rhfa.desafio.zupmovies.mvp.model

import br.com.rhfa.desafio.zupmovies.mvp.presenter.MoviesPresenter
import br.com.rhfa.desafio.zupmovies.network.MoviesServices

open class FindMoviesOnlineModelImpl(var presenter: MoviesPresenter) : FindMoviesOnlineModel {

    override fun getMovies(title: String) {
        MoviesServices.newInstance(presenter)!!.doGetListMovies(title)
    }
}