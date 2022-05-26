package es.maincode.data

import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("characteres/{id}")
    fun getDetail(@Path("id") id: String)
}