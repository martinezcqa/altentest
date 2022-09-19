package es.maincode.openbanktest.view.vo

import es.maincode.domain.common.*

data class CharacterVO(
    var id: Int = 0,
    var name: String = "",
    var status: String = "",
    var species: String = "",
    var type: String = "",
    var gender: String = "",
    var origin: ObjectVO = ObjectVO(),
    var location: ObjectVO = ObjectVO(),
    var image: String = "",
    var episode: List<String> = emptyList(),
    var url: String = "",
    var created: String = ""
) {
    fun getPairInfo(): List<Pair<String, String>> {
        val pairList: MutableList<Pair<String, String>> = mutableListOf()
        pairList.add(Pair("Name", name))
        pairList.add(Pair("Status", status))
        pairList.add(Pair("Species", species))
        pairList.add(Pair("Type", type))
        pairList.add(Pair("Gender", gender))
        pairList.add(Pair("Origin", origin.name))
        pairList.add(Pair("Location", location.name))
        episode.forEachIndexed { index, episode ->
            pairList.add(Pair("Episode $index", episode))
        }
        return pairList
    }
}

data class ObjectVO(
    var name: String = "",
    var url: String = ""
)

fun ObjectBusiness.toPresentation() = ObjectVO(
    name, url
)

fun CharacterBusiness.toPresentation() = CharacterVO(
    id,
    name,
    status,
    species,
    type,
    gender,
    origin.toPresentation(),
    location.toPresentation(),
    image,
    episode,
    url,
    created
)