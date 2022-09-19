package es.maincode.data.list

import es.maincode.data.common.BaseListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ListService {
    @GET("character")
    suspend fun getList(
        @Query("page") page: String = ""
    ): Response<BaseListResponse>
}