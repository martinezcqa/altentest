package es.maincode.data.list

import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.BaseListBusiness
import es.maincode.domain.list.ListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ListRepositoryImpl(
    private val dataSource: ListRemoteDataSource
): ListRepository {

    override suspend fun getList(): Flow<ResponsePair<BaseListBusiness, Unit>> =
        dataSource.getListFlow().map { ResponsePair(it.success?.toDomain(), it.failure) }
}