package br.com.rhfa.desafio.zupmovies.mvp.base

import com.br.rhf.restretrofit.communication.RHFViewInterface

interface BaseView : RHFViewInterface {

    fun getFragment(): BaseViewFragment?

    fun showProgressBar(visibility: Int)

    fun showToast(message: String)

}