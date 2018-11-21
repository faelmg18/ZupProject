package br.com.rhfa.desafio.zupmovies.views.adapter

import android.view.View

import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import br.com.rhfa.desafio.zupmovies.mvp.presenter.MoviesPresenter
import br.com.rhfa.desafio.zupmovies.views.adapter.viewholders.MovieViewHolder

class MoviesAdapter(dataList: MutableList<Movie>, presenter: MoviesPresenter) : BaseRecyclerViewAdapter<Movie, MovieViewHolder>(dataList, presenter) {

    override fun myOnBindViewHolder(holder: MovieViewHolder, position: Int, item: Movie) {
        holder.bind(item)
    }


    /*@Override
    protected int getLayoutId() {
        return R.layout.git_repository_item_adapter;
    }*/

    override fun layoutId(): Int {
        return 0
    }


    override fun myOnCreateViewHolder(parent: View, viewType: Int, mBasePresenterImpl: BasePresenter): MovieViewHolder {
        return MovieViewHolder(parent, mBasePresenterImpl)
    }
}
