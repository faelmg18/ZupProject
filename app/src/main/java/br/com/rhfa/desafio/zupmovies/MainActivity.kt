package br.com.rhfa.desafio.zupmovies

import android.app.Activity
import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseView
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseViewFragment
import br.com.rhfa.desafio.zupmovies.mvp.presenter.MainPresenter
import br.com.rhfa.desafio.zupmovies.mvp.presenter.MoviePresenterImpl
import br.com.rhfa.desafio.zupmovies.mvp.presenter.MoviesPresenter
import br.com.rhfa.desafio.zupmovies.mvp.view.MainView
import br.com.rhfa.desafio.zupmovies.mvp.view.MovieView
import br.com.rhfa.desafio.zupmovies.views.activities.AbstractBottomNavigationBarActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EActivity

open class MainActivity : AbstractBottomNavigationBarActivity<MainPresenter>(), MainView {
    override fun getBaseView(): BaseView {
        return this
    }

    override fun getFragment(): BaseViewFragment? {
        return getCurrentFragment()
    }

    override fun showProgressBar(visibility: Int) {

    }

    override fun showToast(message: String) {

    }

    override fun getActivity(): Activity {
        return this
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_bottom_bar
    }

    override fun newPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun myOnCreate() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
}
