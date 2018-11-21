package br.com.rhfa.desafio.zupmovies.domain

import br.com.rhfa.desafio.zupmovies.database.SerializedList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.j256.ormlite.field.DataType
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "Filmes")
class Movie {

    @SerializedName("Title")
    @Expose
    @DatabaseField
    var title: String? = null
    @SerializedName("Year")
    @Expose
    @DatabaseField
    var year: String? = null
    @SerializedName("Rated")
    @Expose
    @DatabaseField
    var rated: String? = null
    @SerializedName("Released")
    @Expose
    @DatabaseField
    var released: String? = null
    @SerializedName("Runtime")
    @Expose
    @DatabaseField
    var runtime: String? = null
    @SerializedName("Genre")
    @Expose
    @DatabaseField
    var genre: String? = null
    @SerializedName("Director")
    @Expose
    @DatabaseField
    var director: String? = null
    @SerializedName("Writer")
    @Expose
    @DatabaseField
    var writer: String? = null
    @SerializedName("Actors")
    @Expose
    @DatabaseField
    var actors: String? = null
    @SerializedName("Plot")
    @Expose
    @DatabaseField
    var plot: String? = null
    @SerializedName("Language")
    @Expose
    @DatabaseField
    var language: String? = null
    @SerializedName("Country")
    @Expose
    @DatabaseField
    var country: String? = null
    @SerializedName("Awards")
    @Expose
    @DatabaseField
    var awards: String? = null
    @SerializedName("Poster")
    @Expose
    @DatabaseField
    var poster: String? = null
    @SerializedName("Ratings")
    @Expose
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    var ratings: SerializedList<Rating>? = null
    @SerializedName("Metascore")
    @Expose
    @DatabaseField
    var metascore: String? = null
    @SerializedName("imdbRating")
    @Expose
    @DatabaseField
    var imdbRating: String? = null
    @SerializedName("imdbVotes")
    @Expose
    @DatabaseField
    var imdbVotes: String? = null
    @SerializedName("imdbID")
    @Expose
    @DatabaseField
    var imdbID: String? = null
    @SerializedName("Type")
    @Expose
    @DatabaseField
    var type: String? = null
    @SerializedName("DVD")
    @Expose
    @DatabaseField
    var dvd: String? = null
    @SerializedName("BoxOffice")
    @Expose
    @DatabaseField
    var boxOffice: String? = null
    @SerializedName("Production")
    @Expose
    @DatabaseField
    var production: String? = null
    @SerializedName("Website")
    @Expose
    @DatabaseField
    var website: String? = null
    @SerializedName("Response")
    @Expose
    @DatabaseField
    var response: Boolean? = null


    fun getGenere(): String {

        val genereSplit = genre!!.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var genereReplaced = genre

        if (genereSplit.size > 0) {
            genereReplaced = genereSplit[0]
        }

        return genereReplaced!!
    }

}
