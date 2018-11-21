package br.com.rhfa.desafio.zupmovies.database

import android.content.Context
import br.com.rhfa.desafio.zupmovies.domain.Movie
import com.j256.ormlite.dao.Dao

class DatabaseManager(context: Context) : DatabaseHelper(context) {


    public override fun getMovieDao(): Dao<Movie, Int>? {
        return super.getMovieDao()
    }

    companion object {

        private var instance: DatabaseManager? = null

        fun init(ctx: Context): DatabaseManager {
            if (null == instance) {
                instance = DatabaseManager(ctx)
            }
            return instance as DatabaseManager
        }
    }
}