package es.maincode.domain.common

import java.util.*

data class CharacterDataWrapperBusiness(
    var code: Int = 0,
    var status: String = "",
    var copyright: String = "",
    var attributionText: String = "",
    var attributionHTML: String = "",
    var data: CharacterDataContainerBusiness = CharacterDataContainerBusiness(),
    var etag: String = ""
)

data class CharacterDataContainerBusiness(
    var offset: Int = 0,
    var limit: Int = 0,
    var total: Int = 0,
    var count: Int = 0,
    var results: List<CharacterBusiness> = emptyList()
)

data class CharacterBusiness(
    var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var modified: Date = Date(),
    var resourceURI: String = "",
    var urls: List<UrlBusiness> = emptyList(),
    var thumbnail: ImageBusiness = ImageBusiness(),
    var comics: ComicListBusiness = ComicListBusiness(),
    var stories: StoryListBusiness = StoryListBusiness(),
    var events: EventListBusiness = EventListBusiness(),
    var series: SeriesListBusiness = SeriesListBusiness()
)

data class SeriesListBusiness(
    var available: Int = 0,
    var returned: Int = 0,
    var collectionURI: String = "",
    var items: List<SeriesSummaryBusiness> = emptyList()
)

data class SeriesSummaryBusiness(
    var resourceURI: String = "",
    var name: String = ""
)

data class EventListBusiness(
    var available: Int = 0,
    var returned: Int = 0,
    var collectionURI: String = "",
    var items: List<EventSummaryBusiness> = emptyList()
)

data class EventSummaryBusiness(
    var resourceURI: String = "",
    var name: String = ""
)

data class StoryListBusiness(
    var available: Int = 0,
    var returned: Int = 0,
    var collectionURI: String = "",
    var items: List<StorySummaryBusiness> = emptyList()
)

data class StorySummaryBusiness(
    var resourcesURI: String = "",
    var name: String = "",
    var type: String = ""
)

data class ComicListBusiness(
    var available: Int = 0,
    var returned: Int = 0,
    var collectionURI: String = "",
    var items: List<ComicSummaryBusiness> = emptyList()
)

data class ComicSummaryBusiness(
    var resourceURI: String = "",
    var name: String = ""
)

data class UrlBusiness(
    var type: String = "",
    var url: String = ""
)

data class ImageBusiness(
    var path: String = "",
    var extension: String = ""
)