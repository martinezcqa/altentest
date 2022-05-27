package es.maincode.domain.detail

import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.CharacterDataWrapperBusiness
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    suspend fun getDetail(params: Int): Flow<ResponsePair<CharacterDataWrapperBusiness, Unit>>
}