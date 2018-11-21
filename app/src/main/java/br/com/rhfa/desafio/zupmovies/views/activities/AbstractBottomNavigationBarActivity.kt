package br.com.rhfa.desafio.zupmovies.views.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import br.com.rhfa.desafio.zupmovies.R
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseViewFragment
import br.com.rhfa.desafio.zupmovies.views.fragments.FindOnlineMovieFragment
import kotlinx.android.synthetic.main.activity_main.*


abstract class AbstractBottomNavigationBarActivity<T : BasePresenter> : BaseActivity<T>() {

    private var currentFragment: BaseViewFragment? = null
    var lastItemIdMenuSelected: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigation.selectedItemId = R.id.navigation_find_moves
    }


    protected val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                return@OnNavigationItemSelectedListener false
            }
            R.id.navigation_find_moves -> {
                gotoFragment(FindOnlineMovieFragment::class.java, null, item.itemId)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    protected fun gotoFragment(toFragment: Class<out Fragment>, bundle: Bundle?, itemId: Int) {

        if (lastItemIdMenuSelected == itemId) {
            return
        }

        var fragment: Fragment? = null
        try {
            fragment = toFragment.newInstance()

            var mBundle: Bundle? = null

            if (bundle == null) {
                mBundle = Bundle()
            }
            fragment!!.arguments = mBundle

        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        if (fragment == null)
            return

        currentFragment = fragment as BaseViewFragment?


        lastItemIdMenuSelected = itemId
        supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit()
    }

    fun getCurrentFragment(): BaseViewFragment? {
        return currentFragment
    }
}