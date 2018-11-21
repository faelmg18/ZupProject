package br.com.rhfa.desafio.zupmovies.communucation.data_serializer

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.CollectionType
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

open class DataSerializer {

    private var objectMapper: ObjectMapper? = null
    private var instance: DataSerializer? = null
    private val DEFAULT_FORMAT_DATE = "yyyy-MM-dd HH:mm a z"

    constructor(dataSerializerMapperConfiguration: DataSerializerMapperConfiguration) {
        objectMapper = ObjectMapper()
        objectMapper!!.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper!!.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper!!.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
        val df = SimpleDateFormat(dataSerializerMapperConfiguration.getFormatDate())
        objectMapper!!.setDateFormat(df)
    }

    constructor() {
        DataSerializer(DataSerializerMapperConfiguration(DEFAULT_FORMAT_DATE))
    }


    private object Singleton {
        val INSTANCE = DataSerializer()
    }


    companion object {
        val instance: DataSerializer by lazy { Singleton.INSTANCE }
    }

    fun setDateFormat(df: DateFormat) {
        objectMapper!!.setDateFormat(df)
    }

    fun toJson(content: Any): String {
        try {
            return objectMapper!!.writeValueAsString(content)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun <T> toObject(json: String, targetClass: Class<*>): T {
        try {
            return objectMapper!!.readValue(json, targetClass) as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

    fun <T> toObject(json: String, type: TypeReference<T>): T {
        try {
            return objectMapper!!.readValue<Any>(json, type) as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun <T> toObject(jsonAnswer: String, collectionType: CollectionType): List<T> {

        try {
            return objectMapper!!.readValue<Any>(jsonAnswer, collectionType) as List<T>
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun <T> toObjectList(jsonAnswer: String, targetClass: Class<T>): List<T> {
        try {

            val value: List<T> = objectMapper!!.readValue(jsonAnswer, object : TypeReference<List<T>>() {})
            return value
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun <T> toObjectArrayList(jsonAnswer: String, targetClass: Class<T>): ArrayList<T> {
        try {

            val value: ArrayList<T> = objectMapper!!.readValue(jsonAnswer, object : TypeReference<List<T>>() {})
            return value

        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}