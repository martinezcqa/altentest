package es.maincode.data.detail

import es.maincode.domain.base.ResponsePair
import es.maincode.domain.common.CharacterBusiness
import es.maincode.domain.detail.DetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DetailRepositoryImpl(
    private val dataSource: DetailRemoteDataSource
): DetailRepository {
    override suspend fun getDetail(params: Int): Flow<ResponsePair<CharacterBusiness, Unit>> =
        dataSource.getDetail(params).map { ResponsePair(it.success?.toDomain(), it.failure) }
}