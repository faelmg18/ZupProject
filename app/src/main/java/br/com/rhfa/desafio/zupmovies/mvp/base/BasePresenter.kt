package br.com.rhfa.desafio.zupmovies.mvp.base

import com.br.rhf.restretrofit.communication.RHFViewInterface


interface BasePresenter : RHFViewInterface {
    fun setView(view: BaseView)

    fun showToast(message: String)

    fun showProgressBar(status: Boolean)
}