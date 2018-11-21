package br.com.rhfa.desafio.zupmovies.communucation.services_interface

import br.com.rhfa.desafio.zupmovies.domain.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesSerivceInterface {
    @GET("?type=movie")
    fun doGetListMovies(@Query("t") movieTitle: String,
                        @Query("apikey") apiKey: String): Call<Movie>
}
