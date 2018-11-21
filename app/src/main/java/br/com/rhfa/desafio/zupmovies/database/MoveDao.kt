package br.com.rhfa.desafio.zupmovies.database

import br.com.rhfa.desafio.zupmovies.domain.Movie
import java.sql.SQLException

interface MoveDao {

    fun retrieveAll(): List<Movie>?

    fun retrieveAllCategorized(): List<Movie>?

    fun retrieveById(id: Int): Movie?

    @Throws(SQLException::class)
    fun retrieveByTitle(title: String): Movie?

    @Throws(SQLException::class)
    fun save(movie: Movie): Int

    @Throws(SQLException::class)
    fun delete(movie: Movie)

}
