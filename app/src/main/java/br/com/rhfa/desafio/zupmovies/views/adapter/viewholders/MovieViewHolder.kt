package br.com.rhfa.desafio.zupmovies.views.adapter.viewholders

import android.view.View

import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter

class MovieViewHolder(itemView: View, presenter: BasePresenter) : AbstractViewHolder<Movie>(itemView, presenter) {

    override fun bind(item: Movie) {
    }
}
