package es.maincode.domain.common

data class BaseListBusiness(
    var info: InfoBusiness = InfoBusiness(),
    var results: List<CharacterBusiness> = emptyList()
)

data class InfoBusiness(
    var count: Int = 0,
    var pages: Int = 0,
    var next: String = "",
    var prev: String = ""
)

data class CharacterBusiness(
    var id: Int = 0,
    var name: String = "",
    var status: String = "",
    var species: String = "",
    var type: String = "",
    var gender: String = "",
    var origin: ObjectBusiness = ObjectBusiness(),
    var location: ObjectBusiness = ObjectBusiness(),
    var image: String = "",
    var episode: List<String> = emptyList(),
    var url: String = "",
    var created: String = ""
)

data class ObjectBusiness(
    var name: String = "",
    var url: String = ""
)