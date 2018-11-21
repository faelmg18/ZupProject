package br.com.rhfa.desafio.zupmovies.views.adapter

import android.view.View

import br.com.rhfa.desafio.zupmovies.domain.CategorizedMovies
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import br.com.rhfa.desafio.zupmovies.views.adapter.viewholders.MyViewHolderMoviesCategorized

class CategorizedMoviesAdapter(dataList: MutableList<CategorizedMovies>?, basePresenterImpl: BasePresenter) : BaseRecyclerViewAdapter<CategorizedMovies, MyViewHolderMoviesCategorized>(dataList, basePresenterImpl) {

    override fun layoutId(): Int {
        return 0
    }

    override fun myOnCreateViewHolder(parent: View, viewType: Int, mBasePresenterImpl: BasePresenter): MyViewHolderMoviesCategorized {
        return MyViewHolderMoviesCategorized(parent, mBasePresenterImpl)
    }

    override fun myOnBindViewHolder(holder: MyViewHolderMoviesCategorized, position: Int, item: CategorizedMovies) {
        holder.bind(item)
    }
}
