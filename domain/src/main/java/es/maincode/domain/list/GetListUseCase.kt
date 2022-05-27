package es.maincode.domain.list

import es.maincode.domain.base.BaseUseCase
import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.CharacterDataWrapperBusiness
import kotlinx.coroutines.flow.Flow

class GetListUseCase(
    private val repository: ListRepository
) : BaseUseCase<Unit, CharacterDataWrapperBusiness, Unit>() {

    override suspend fun run(params: Unit): Flow<ResponsePair<CharacterDataWrapperBusiness, Unit>> =
        repository.getList()
}