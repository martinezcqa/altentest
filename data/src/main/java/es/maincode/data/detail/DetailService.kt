package es.maincode.data.detail

import es.maincode.data.common.CharacterDataWrapperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailService {
    @GET("characters/{id}")
    suspend fun getDetail(
        @Path("id") id: Int,
        @Query("apikey") apikey: String = "4e7a4d4504d01a22c4b9884474797718",
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ): Response<CharacterDataWrapperResponse>
}