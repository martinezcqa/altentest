package es.maincode.domain.list

import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.CharacterDataWrapperBusiness
import kotlinx.coroutines.flow.Flow

interface ListRepository {
    suspend fun getList(): Flow<ResponsePair<CharacterDataWrapperBusiness, Unit>>
}