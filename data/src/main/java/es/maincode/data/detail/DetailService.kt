package es.maincode.data.detail

import es.maincode.data.common.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("character/{id}")
    suspend fun getDetail(
        @Path("id") id: Int
    ): Response<CharacterResponse>
}