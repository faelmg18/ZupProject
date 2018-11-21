package br.com.rhfa.desafio.zupmovies.mvp.base

import br.com.rhfa.desafio.zupmovies.domain.Movie

interface BaseListView : BaseView {
    fun onItemAdapterClick(item: Movie)
}
