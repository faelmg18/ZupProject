package br.com.rhfa.desafio.zupmovies.mvp.model

import android.content.Context
import br.com.rhfa.desafio.zupmovies.database.DataBaseFactory
import br.com.rhfa.desafio.zupmovies.database.MovieDaoImpl
import br.com.rhfa.desafio.zupmovies.domain.Movie
import java.sql.SQLException

class FindMovesOfflineModelImpl(private val context: Context) : FindMoviesOfflineModel {
    private val movieDao: MovieDaoImpl

    init {
        movieDao = DataBaseFactory.getInstance(context)!!.createMoveDao
    }

    override fun getMovie(title: String): Movie? {
        try {
            return movieDao.retrieveByTitle(title)
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return null
    }

    override fun getMovies(title: String): List<Movie>? {
        return null
    }

    override fun saveMovie(movie: Movie): Int {
        try {
            return movieDao.save(movie)
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return -1
    }
}
