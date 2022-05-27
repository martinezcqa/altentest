package es.maincode.data.list

import es.maincode.data.common.CharacterDataWrapperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ListService {
    @GET("characters")
    suspend fun getList(
        @Query("apikey") apikey: String = "4e7a4d4504d01a22c4b9884474797718",
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ): Response<CharacterDataWrapperResponse>
}