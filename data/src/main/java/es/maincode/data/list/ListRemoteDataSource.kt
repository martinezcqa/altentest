package es.maincode.data.list

import es.maincode.data.common.BaseListResponse
import es.maincode.domain.base.ResponsePair
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListRemoteDataSource @Inject constructor(
    private val service: ListService
) {

    suspend fun getListFlow(): Flow<ResponsePair<BaseListResponse, Unit>> = flow {
        val response = service.getList()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(ResponsePair<BaseListResponse, Unit>(success = it))
            } ?: run {
                emit(ResponsePair<BaseListResponse, Unit>(failure = Unit))
            }
        } else {
            emit(ResponsePair<BaseListResponse, Unit>(failure = Unit))
        }
    }
}