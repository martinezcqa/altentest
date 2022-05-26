package es.maincode.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ListService {
    @GET("characters")
    fun getList(@Query("apikey") apikey: String = "4e7a4d4504d01a22c4b9884474797718")
}