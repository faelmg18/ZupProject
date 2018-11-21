package br.com.rhfa.desafio.zupmovies.database

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.com.rhfa.desafio.zupmovies.domain.Movie
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import java.util.*

open class DatabaseHelper(context: Context) : OrmLiteSqliteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private var movieDao: Dao<Movie, Int>? = null

    override fun onCreate(database: SQLiteDatabase,
                          connectionSource: ConnectionSource) {
        try {
            TableUtils.createTable(connectionSource, Movie::class.java)
        } catch (e: SQLException) {
            Log.e(DatabaseHelper::class.java.name, "Can't create database", e)
            throw RuntimeException(e)
        } catch (e: java.sql.SQLException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onUpgrade(db: SQLiteDatabase, connectionSource: ConnectionSource,
                           oldVersion: Int, newVersion: Int) {
        try {
            val allSql = ArrayList<String>()

            for (sql in allSql) {
                db.execSQL(sql)
            }
        } catch (e: SQLException) {
            Log.e(DatabaseHelper::class.java.name, "exception during onUpgrade",
                    e)
            throw RuntimeException(e)
        }

    }

    protected open fun getMovieDao(): Dao<Movie, Int>? {
        if (null == movieDao) {
            try {
                movieDao = getDao(Movie::class.java)
            } catch (e: java.sql.SQLException) {
                e.printStackTrace()
            }

        }
        return movieDao
    }

    companion object {

        private val DATABASE_NAME = "movie.sqlite"
        private val DATABASE_VERSION = 2
    }
}