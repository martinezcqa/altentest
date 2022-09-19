package es.maincode.data.common

import es.maincode.domain.common.*

data class BaseListResponse(
    var info: InfoResponse? = InfoResponse(),
    var results: List<CharacterResponse>? = emptyList()
) {
    fun toDomain() = BaseListBusiness(
        info?.toDomain() ?: InfoBusiness(),
        results?.map { it.toDomain() } ?: emptyList()
    )
}

data class InfoResponse(
    var count: Int? = 0,
    var pages: Int? = 0,
    var next: String? = "",
    var prev: String? = ""
) {
    fun toDomain() = InfoBusiness(
        count ?: 0,
        pages ?: 0,
        next ?: "",
        prev ?: ""
    )
}

data class CharacterResponse(
    var id: Int? = 0,
    var name: String? = "",
    var status: String? = "",
    var species: String? = "",
    var type: String? = "",
    var gender: String? = "",
    var origin: ObjectResponse? = ObjectResponse(),
    var location: ObjectResponse? = ObjectResponse(),
    var image: String? = "",
    var episode: List<String>? = emptyList(),
    var url: String? = "",
    var created: String? = ""
) {
    fun toDomain() = CharacterBusiness(
        id ?: 0,
        name ?: "",
        status ?: "",
        species ?: "",
        type ?: "",
        gender ?: "",
        origin?.toDomain() ?: ObjectBusiness(),
        location?.toDomain() ?: ObjectBusiness(),
        image ?: "",
        episode ?: emptyList(),
        url ?: "",
        created ?: ""

    )
}

data class ObjectResponse(
    var name: String? = "",
    var url: String? = ""
) {
    fun toDomain() = ObjectBusiness(
        name ?: "",
        url ?: ""
    )
}