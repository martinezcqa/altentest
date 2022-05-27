package es.maincode.data.list

import es.maincode.data.common.CharacterDataWrapperResponse
import es.maincode.domain.base.ResponsePair
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.apache.commons.codec.digest.DigestUtils
import javax.inject.Inject

class ListRemoteDataSource @Inject constructor(
    private val service: ListService
) {

    suspend fun getListFlow(): Flow<ResponsePair<CharacterDataWrapperResponse, Unit>> = flow {
        val ts = (System.currentTimeMillis() / 1000).toString()
        val hash =
            DigestUtils.md5Hex("${ts}09dbd06ee2b3dcd432882eab1ed4d8ea3464e6974e7a4d4504d01a22c4b9884474797718")
        val response = service.getList(
            ts = ts,
            hash = hash
        )
        if (response.isSuccessful) {
            response.body()?.let {
                emit(ResponsePair<CharacterDataWrapperResponse, Unit>(success = it))
            } ?: run {
                emit(ResponsePair<CharacterDataWrapperResponse, Unit>(failure = Unit))
            }
        } else {
            emit(ResponsePair<CharacterDataWrapperResponse, Unit>(failure = Unit))
        }
    }
}