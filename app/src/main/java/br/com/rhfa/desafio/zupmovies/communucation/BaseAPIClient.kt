package br.com.rhfa.desafio.zupmovies.communucation

import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import com.br.rhf.restretrofit.communication.AbstractAPIClient
import com.br.rhf.restretrofit.communication.RHFViewInterface

open class BaseAPIClient<T>(rhfViewInterface: RHFViewInterface) : AbstractAPIClient<T>(rhfViewInterface) {

    val base: BasePresenter = rhfViewInterface as BasePresenter

    override fun getBaseUrl(): String {
        return "http://www.omdbapi.com/"
    }

    override fun onEnd() {
        base.showProgressBar(false)
    }

    override fun onStart() {
        base.showProgressBar(true)
    }
}
