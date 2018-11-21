package br.com.rhfa.desafio.zupmovies.database

import java.io.Serializable
import java.util.*

class SerializedList<E> : ArrayList<E>(), Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
