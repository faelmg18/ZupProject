package br.com.rhfa.desafio.zupmovies.views.fragments

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import br.com.rhfa.desafio.zupmovies.R
import br.com.rhfa.desafio.zupmovies.domain.Movie
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseViewFragment
import br.com.rhfa.desafio.zupmovies.mvp.presenter.MoviePresenterImpl
import br.com.rhfa.desafio.zupmovies.mvp.presenter.MoviesPresenter
import br.com.rhfa.desafio.zupmovies.mvp.view.MovieView
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.find_movies_frament.*

class FindOnlineMovieFragment : BaseFragments<MoviesPresenter>(), MovieView {

    override fun layoutId(): Int {
        return R.layout.find_movies_frament
    }

    private var movieToSave: Movie? = null
    private var imageLoader = ImageLoader.getInstance()
    override fun newPresenter(): MoviesPresenter {
        return MoviePresenterImpl(this!!.activity!!)
    }

    override fun myOnCreate(view: View, savedInstanceState: Bundle?) {
    }

    override fun myOnViewCreate(view: View, savedInstanceState: Bundle?) {
        fab!!.setOnClickListener({

            if (movieToSave != null) {
                presenter!!.saveMove(movieToSave!!)
                movieToSave = null
            }
        })

        simpleViewAnimator!!.setInAnimation(AnimationUtils.loadAnimation(
                activity,
                R.anim.slide_up))

        simpleViewAnimator!!.setOutAnimation(AnimationUtils.loadAnimation(
                activity,
                R.anim.slide_down))

        searchEditText.setDrawableClickListener({ findMovies() })

        performSearch()
    }

    private fun findMovies() {

        var title = searchEditText.text.toString()
        performSearch()
        presenter!!.findMove(activity!!.intent.extras, title)
    }

    private fun performSearch() {
        searchEditText.clearFocus()
        val `in` = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        `in`.hideSoftInputFromWindow(searchEditText.windowToken, 0)
    }

    override fun showOrHideViewAnimation(visibility: Int) {
        simpleViewAnimator.visibility = visibility
    }

    override fun onFindMove(movie: Movie) {
        movieToSave = movie
        textViewTitleMovie.text = movie.title
        textViewActors.text = movie.actors
        textViewPlot.text = movie.plot
        simpleViewAnimator.visibility = View.VISIBLE
        if (TextUtils.isEmpty(movie.poster) || movie.poster.equals("N/A")) {
            imageViewMovie.setImageBitmap(null)
        }
        imageLoader.displayImage(movie.poster, imageViewMovie)
    }

    override fun showProgressBar(visibility: Int) {
        progressBarFindMove.visibility = visibility
    }

    override fun onSaveInstanceState(outState: Bundle) {
        //outState.putSerializable(RepositoriesPresenter.REPOSITORIES_KEY, getPresenter().getRepository());
        super.onSaveInstanceState(outState)
    }

    override fun getFragment(): BaseViewFragment? {
        return this
    }
}