package br.com.rhfa.desafio.zupmovies.views.adapter.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter

abstract class AbstractViewHolder<T>(itemView: View, val presenter: BasePresenter) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: T)
}
