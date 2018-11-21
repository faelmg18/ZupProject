package br.com.rhfa.desafio.zupmovies.mvp.presenter

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import br.com.rhfa.desafio.zupmovies.R
import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseView
import br.com.rhfa.desafio.zupmovies.mvp.model.FindMovesOfflineModelImpl
import br.com.rhfa.desafio.zupmovies.mvp.model.FindMoviesOfflineModel
import br.com.rhfa.desafio.zupmovies.mvp.model.FindMoviesOnlineModel
import br.com.rhfa.desafio.zupmovies.mvp.model.FindMoviesOnlineModelImpl
import br.com.rhfa.desafio.zupmovies.mvp.view.MovieView

class MoviePresenterImpl(val context: Context) : MoviesPresenter {

    private var view: MovieView? = null
    private val model: FindMoviesOnlineModel
    private val modelOffline: FindMoviesOfflineModel

    init {
        model = FindMoviesOnlineModelImpl(this)
        modelOffline = FindMovesOfflineModelImpl(context)
    }

    override fun findMove(savedInstanceState: Bundle?, title: String) {

        view!!.showOrHideViewAnimation(View.GONE)

        val movie = modelOffline.getMovie(title)
        if (movie != null) {
            onFindMove(movie)
            return
        }

        model.getMovies(title)
    }

    override fun saveMove(movie: Movie) {
        val result = modelOffline.saveMovie(movie)
        if (result == -1) {
            view!!.showToast(context.getString(R.string.movie_dont_save))
        } else {
            view!!.showToast(context.getString(R.string.movie_saved))
        }
    }

    override fun onFindMove(movie: Movie) {

        if (!movie.response!!) {
            view!!.showToast(this.context.getString(R.string.movie_not_found))
            return
        }
        view!!.showOrHideViewAnimation(View.VISIBLE)
        view!!.onFindMove(movie)
    }

    override fun showToast(message: String) {
        view!!.showToast(message)
    }

    override fun runOnUiThread(action: Runnable) {
        view!!.runOnUiThread(action)
    }

    override fun getActivity(): Activity? {
        return null
    }

    override fun setView(view: BaseView) {
        this.view = view as MovieView
    }

    override fun showProgressBar(status: Boolean) {
        val visibilidade = if (status) View.VISIBLE else View.GONE
        view!!.showProgressBar(visibilidade)
    }
}