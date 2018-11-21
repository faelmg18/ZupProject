package br.com.rhfa.desafio.zupmovies.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseView
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.UiThread


abstract class BaseActivity<out T : BasePresenter> : AppCompatActivity() {

    abstract fun myOnCreate()
    abstract fun getLayoutId(): Int
    abstract fun getBaseView(): BaseView

    protected abstract fun newPresenter(): T
    private var presenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        if (presenter == null) {
            presenter = newPresenter()
        }

        presenter!!.setView(getBaseView())

        myOnCreate()
    }


    fun getPresenter(): T {
        return this.presenter!!
    }
}