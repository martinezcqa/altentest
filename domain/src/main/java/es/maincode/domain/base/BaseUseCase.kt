package es.maincode.domain.base

import kotlinx.coroutines.flow.Flow


abstract class BaseUseCase<PARAMS, SUCCESS, FAILURE> {
    abstract suspend fun run(params: PARAMS): Flow<ResponsePair<SUCCESS, FAILURE>>
    suspend operator fun invoke(
        params: PARAMS
    ): Flow<ResponsePair<SUCCESS, FAILURE>> {
        return run(params)
    }
}

class ResponsePair<SUCCESS, FAILURE>(success: SUCCESS? = null, failure: FAILURE? = null) {
    private val pair = Pair(success, failure)
    val success: SUCCESS? = pair.first
    val failure: FAILURE? = pair.second
}