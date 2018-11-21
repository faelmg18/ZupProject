package br.com.rhfa.desafio.zupmovies.views.adapter.viewholders

import android.view.View
import br.com.rhfa.desafio.zupmovies.domain.CategorizedMovies
import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import java.util.*

class MyViewHolderMoviesCategorized(itemView: View, presenter: BasePresenter) : AbstractViewHolder<CategorizedMovies>(itemView, presenter) {

    fun getElementByIndex(map: LinkedHashMap<*, *>, index: Int): List<Movie> {
        return map[map.keys.toTypedArray()[index]] as List<Movie>
    }

    override fun bind(item: CategorizedMovies) {
    }
}
