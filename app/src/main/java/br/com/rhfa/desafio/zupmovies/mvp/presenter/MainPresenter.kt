package br.com.rhfa.desafio.zupmovies.mvp.presenter

import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseView
import br.com.rhfa.desafio.zupmovies.mvp.view.MainView
import br.com.rhfa.desafio.zupmovies.views.activities.BaseActivity

class MainPresenter : BasePresenter {

    private var view: MainView? = null

    override fun setView(view: BaseView) {
        this.view = view as MainView
    }

    override fun runOnUiThread(action: Runnable) {
        view!!.runOnUiThread(action)
    }

    override fun getActivity(): BaseActivity<*>? {
        return view as BaseActivity<*>?
    }

    override fun showToast(message: String) {
        view!!.showToast(message)
    }

    override fun showProgressBar(status: Boolean) {

    }
}
