package br.com.rhfa.desafio.zupmovies.database

import android.content.Context

class DataBaseFactory(context: Context) {
    private val databaseManager: DatabaseManager = DatabaseManager.init(context)

    val createMoveDao: MovieDaoImpl
        get() = MovieDaoImpl.getInstance(databaseManager)!!

    companion object {

        @Volatile
        private var instance: DataBaseFactory? = null

        fun getInstance(context: Context): DataBaseFactory? {

            if (instance == null) {
                instance = DataBaseFactory(context)
            }

            return instance
        }
    }

}
