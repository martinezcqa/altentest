package es.maincode.domain.list

import es.maincode.domain.base.BaseUseCase
import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.BaseListBusiness
import kotlinx.coroutines.flow.Flow

class GetListUseCase(
    private val repository: ListRepository
) : BaseUseCase<Unit, BaseListBusiness, Unit>() {

    override suspend fun run(params: Unit): Flow<ResponsePair<BaseListBusiness, Unit>> =
        repository.getList()
}