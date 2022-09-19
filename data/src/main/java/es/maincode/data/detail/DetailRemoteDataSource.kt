package es.maincode.data.detail

import es.maincode.data.common.CharacterResponse
import es.maincode.domain.base.ResponsePair
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailRemoteDataSource @Inject constructor(
    private val service: DetailService
) {
    suspend fun getDetail(id: Int): Flow<ResponsePair<CharacterResponse, Unit>> = flow {
        val response = service.getDetail(id = id)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(ResponsePair<CharacterResponse, Unit>(success = it))
            } ?: run {
                emit(ResponsePair<CharacterResponse, Unit>(failure = Unit))
            }
        } else {
            emit(ResponsePair<CharacterResponse, Unit>(failure = Unit))
        }
    }
}