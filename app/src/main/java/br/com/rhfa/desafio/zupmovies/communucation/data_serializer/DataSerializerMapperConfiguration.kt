package br.com.rhfa.desafio.zupmovies.communucation.data_serializer

class DataSerializerMapperConfiguration {

    private var formatDate: String? = null

    constructor(formatDate: String) {
        this.formatDate = formatDate
    }


    fun getFormatDate(): String? {
        return formatDate
    }

    fun setFormatDate(formatDate: String) {
        this.formatDate = formatDate
    }

}