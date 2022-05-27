package es.maincode.openbanktest.view.vo

import es.maincode.domain.common.*
import java.util.*

data class CharacterDataWrapperVO(
    var code: Int,
    var status: String,
    var copyright: String,
    var attributionText: String,
    var attributionHTML: String,
    var data: CharacterDataContainerVO,
    var etag: String
)

fun CharacterDataWrapperBusiness.toPresentation() = CharacterDataWrapperVO(
    code,
    status,
    copyright,
    attributionText,
    attributionHTML,
    data.toPresentation(),
    etag
)

data class CharacterDataContainerVO(
    var offset: Int,
    var limit: Int,
    var total: Int,
    var count: Int,
    var results: List<CharacterVO>
)

fun CharacterDataContainerBusiness.toPresentation() = CharacterDataContainerVO(
    offset,
    limit,
    total,
    count,
    results.map { it.toPresentation() }
)

data class CharacterVO(
    var id: Int,
    var name: String,
    var description: String,
    var modified: Date,
    var resourceURI: String,
    var urls: List<UrlVO>,
    var thumbnail: ImageVO,
    var comics: ComicListVO,
    var stories: StoryListVO,
    var events: EventListVO,
    var series: SeriesListVO
) {
    fun getPairInfo(): List<Pair<String, String>> {
        val pairList: MutableList<Pair<String, String>> = mutableListOf()
        pairList.add(Pair("Name", name))
        pairList.add(Pair("Description", description))
        comics.items.forEachIndexed { index, comicSummaryVO ->
            pairList.add(Pair("Comic $index", comicSummaryVO.name))
        }
        stories.items.forEachIndexed { index, storySummaryVO ->
            pairList.add(Pair("Story $index", storySummaryVO.name))
        }
        events.items.forEachIndexed { index, eventSummaryVO ->
            pairList.add(Pair("Event $index", eventSummaryVO.name))
        }
        series.items.forEachIndexed { index, seriesSummaryVO ->
            pairList.add(Pair("Serie $index", seriesSummaryVO.name))
        }
        return pairList
    }
}

fun CharacterBusiness.toPresentation() = CharacterVO(
    id,
    name,
    description,
    modified,
    resourceURI,
    urls.map { it.toPresentation() },
    thumbnail.toPresentation(),
    comics.toPresentation(),
    stories.toPresentation(),
    events.toPresentation(),
    series.toPresentation()
)

data class SeriesListVO(
    var available: Int,
    var returned: Int,
    var collectionURI: String,
    var items: List<SeriesSummaryVO>
)

fun SeriesListBusiness.toPresentation() = SeriesListVO(
    available,
    returned,
    collectionURI,
    items.map { it.toPresentation() }
)

data class SeriesSummaryVO(
    var resourceURI: String,
    var name: String
)

fun SeriesSummaryBusiness.toPresentation() = SeriesSummaryVO(
    resourceURI,
    name
)

data class EventListVO(
    var available: Int,
    var returned: Int,
    var collectionURI: String,
    var items: List<EventSummaryVO>
)

fun EventListBusiness.toPresentation() = EventListVO(
    available,
    returned,
    collectionURI,
    items.map { it.toPresentation() }
)

data class EventSummaryVO(
    var resourceURI: String,
    var name: String
)

fun EventSummaryBusiness.toPresentation() = EventSummaryVO(
    resourceURI,
    name
)

data class StoryListVO(
    var available: Int,
    var returned: Int,
    var collectionURI: String,
    var items: List<StorySummaryVO>
)

fun StoryListBusiness.toPresentation() = StoryListVO(
    available,
    returned,
    collectionURI,
    items.map { it.toPresentation() }
)

data class StorySummaryVO(
    var resourcesURI: String,
    var name: String,
    var type: String
)

fun StorySummaryBusiness.toPresentation() = StorySummaryVO(
    resourcesURI,
    name,
    type
)

data class ComicListVO(
    var available: Int,
    var returned: Int,
    var collectionURI: String,
    var items: List<ComicSummaryVO>
)

fun ComicListBusiness.toPresentation() = ComicListVO(
    available,
    returned,
    collectionURI,
    items.map { it.toPresentation() }
)

data class ComicSummaryVO(
    var resourceURI: String,
    var name: String
)

fun ComicSummaryBusiness.toPresentation() = ComicSummaryVO(
    resourceURI,
    name
)

data class UrlVO(
    var type: String,
    var url: String
)

fun UrlBusiness.toPresentation() = UrlVO(
    type,
    url
)

data class ImageVO(
    var path: String,
    var extension: String
)

fun ImageBusiness.toPresentation() = ImageVO(
    path,
    extension
)