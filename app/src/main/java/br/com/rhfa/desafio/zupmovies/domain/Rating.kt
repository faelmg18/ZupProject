package br.com.rhfa.desafio.zupmovies.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Rating : Serializable {

    companion object {
        private const val serialVersionUID: Long = 1L
    }

    @SerializedName("Source")
    @Expose
    var source: String? = null
    @SerializedName("Value")
    @Expose
    var value: String? = null

}