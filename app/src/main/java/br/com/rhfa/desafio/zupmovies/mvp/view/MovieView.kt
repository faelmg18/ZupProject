package br.com.rhfa.desafio.zupmovies.mvp.view

import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseView

interface MovieView : BaseView {
    fun onFindMove(movie: Movie)
    fun showOrHideViewAnimation(visibility: Int)
}
