package br.com.rhfa.desafio.zupmovies.database

import java.io.Serializable
import java.util.ArrayList

class SerializedList<E> : ArrayList<E>(), Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
/*
java.io.InvalidClassException: br.com.rhfa.desafio.zupmovies.database.SerializedList; local class incompatible: stream classdesc serialVersionUID = 6330066956456467323, local class serialVersionUID = 8045848329745992637*/
