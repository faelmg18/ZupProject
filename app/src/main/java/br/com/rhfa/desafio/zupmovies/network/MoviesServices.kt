package br.com.rhfa.desafio.zupmovies.network


import com.br.rhf.restretrofit.communication.APIClientResponseListener

import java.util.ArrayList

import br.com.rhfa.desafio.zupmovies.communucation.BaseAPIClient
import br.com.rhfa.desafio.zupmovies.communucation.services_interface.MoviesSerivceInterface
import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import br.com.rhfa.desafio.zupmovies.mvp.presenter.MoviesPresenter
import retrofit2.Call

class MoviesServices(private val basePresenter: BasePresenter) : BaseAPIClient<MoviesSerivceInterface>(basePresenter) {

    fun doGetListMovies(title: String) {
        val call = `interface`.doGetListMovies(title, "d08bea08")
        execute(call, object : APIClientResponseListener<Movie> {
            override fun onSuccess(obj: Movie) {
                (basePresenter as MoviesPresenter).onFindMove(obj)
            }

            override fun onError(obj: Call<Movie>, t: Throwable) {
                basePresenter.showToast(t.message!!)
            }
        })
    }

    companion object {

        @Volatile
        private var instance: MoviesServices? = null

        fun newInstance(basePresenter: BasePresenter): MoviesServices? {
            instance = MoviesServices(basePresenter)
            return instance
        }
    }
}
