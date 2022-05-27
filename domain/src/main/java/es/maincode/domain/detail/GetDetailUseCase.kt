package es.maincode.domain.detail

import es.maincode.domain.base.BaseUseCase
import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.CharacterDataWrapperBusiness
import kotlinx.coroutines.flow.Flow

class GetDetailUseCase(
    private val repository: DetailRepository
): BaseUseCase<Int, CharacterDataWrapperBusiness, Unit>() {

    override suspend fun run(params: Int): Flow<ResponsePair<CharacterDataWrapperBusiness, Unit>> {
        return repository.getDetail(params)
    }
}