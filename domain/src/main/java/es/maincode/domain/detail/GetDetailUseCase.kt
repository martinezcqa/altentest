package es.maincode.domain.detail

import es.maincode.domain.base.BaseUseCase
import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.CharacterBusiness
import kotlinx.coroutines.flow.Flow

class GetDetailUseCase(
    private val repository: DetailRepository
): BaseUseCase<Int, CharacterBusiness, Unit>() {

    override suspend fun run(params: Int): Flow<ResponsePair<CharacterBusiness, Unit>> {
        return repository.getDetail(params)
    }
}