package br.com.rhfa.desafio.zupmovies.database

import com.j256.ormlite.dao.Dao

import java.sql.SQLException

import br.com.rhfa.desafio.zupmovies.domain.Movie

class MovieDaoImpl (databaseManager: DatabaseManager) : MoveDao {
    internal var movieDao: Dao<Movie, Int>? = null

    init {
        movieDao = databaseManager.getMovieDao()
    }

    override fun retrieveAll(): List<Movie> {

        var list: List<Movie>? = null
        try {
            list = movieDao!!.queryBuilder().query()
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return list!!
    }

    override fun retrieveAllCategorized(): List<Movie>? {
        return null
    }

    override fun retrieveById(id: Int): Movie? {
        return null
    }

    @Throws(SQLException::class)
    override fun retrieveByTitle(title: String): Movie? {
        val movie = movieDao!!.queryBuilder().where().like("title", title).queryForFirst()
        return movie
    }

    @Throws(SQLException::class)
    override fun save(movie: Movie): Int {
        return movieDao!!.create(movie)
    }

    @Throws(SQLException::class)
    override fun delete(movie: Movie) {
        movieDao!!.delete(movie)
    }

    companion object {

        @Volatile
        private var intance: MovieDaoImpl? = null

        fun getInstance(databaseManager: DatabaseManager): MovieDaoImpl? {
            if (intance == null) {
                intance = MovieDaoImpl(databaseManager)
            }
            return intance
        }
    }

}
