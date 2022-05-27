package es.maincode.data.common

import es.maincode.domain.common.*
import java.util.*

data class CharacterDataWrapperResponse(
    var code: Int?,
    var status: String?,
    var copyright: String?,
    var attributionText: String?,
    var attributionHTML: String?,
    var data: CharacterDataContainerResponse?,
    var etag: String
) {
    fun toDomain() = CharacterDataWrapperBusiness(
        code ?: 0,
        status ?: "",
        copyright ?: "",
        attributionText ?: "",
        attributionHTML ?: "",
        data?.toDomain() ?: CharacterDataContainerBusiness(),
        etag ?: ""
    )
}

data class CharacterDataContainerResponse(
    var offset: Int?,
    var limit: Int?,
    var total: Int?,
    var count: Int?,
    var results: List<CharacterResponse>?
) {
    fun toDomain() = CharacterDataContainerBusiness(
        offset ?: 0,
        limit ?: 0,
        total ?: 0,
        count ?: 0,
        results?.map { it.toDomain() } ?: emptyList()
    )
}

data class CharacterResponse(
    var id: Int?,
    var name: String?,
    var description: String?,
    var modified: Date?,
    var resourceURI: String?,
    var urls: List<UrlResponse>?,
    var thumbnail: ImageResponse?,
    var comics: ComicListResponse?,
    var stories: StoryListResponse?,
    var events: EventListResponse?,
    var series: SeriesListResponse?
) {
    fun toDomain() = CharacterBusiness(
        id ?: 0,
        name ?: "",
        description ?: "",
        modified ?: Date(),
        resourceURI ?: "",
        urls?.map { it.toDomain() } ?: emptyList(),
        thumbnail?.toDomain() ?: ImageBusiness(),
        comics?.toDomain() ?: ComicListBusiness(),
        stories?.toDomain() ?: StoryListBusiness(),
        events?.toDomain() ?: EventListBusiness(),
        series?.toDomain() ?: SeriesListBusiness()
    )
}

data class SeriesListResponse(
    var available: Int?,
    var returned: Int?,
    var collectionURI: String?,
    var items: List<SeriesSummaryResponse>?
) {
    fun toDomain() = SeriesListBusiness(
        available ?: 0,
        returned ?: 0,
        collectionURI ?: "",
        items?.map { it.toDomain() } ?: emptyList()
    )
}

data class SeriesSummaryResponse(
    var resourceURI: String?,
    var name: String?
) {
    fun toDomain() = SeriesSummaryBusiness(
        resourceURI ?: "",
        name ?: ""
    )
}

data class EventListResponse(
    var available: Int?,
    var returned: Int?,
    var collectionURI: String?,
    var items: List<EventSummaryResponse>?
) {
    fun toDomain() = EventListBusiness(
        available ?: 0,
        returned ?: 0,
        collectionURI ?: "",
        items?.map { it.toDomain() } ?: emptyList()
    )
}

data class EventSummaryResponse(
    var resourceURI: String?,
    var name: String?
) {
    fun toDomain() = EventSummaryBusiness(
        resourceURI ?: "",
        name ?: ""
    )
}

data class StoryListResponse(
    var available: Int?,
    var returned: Int?,
    var collectionURI: String?,
    var items: List<StorySummaryResponse>?
) {
    fun toDomain() = StoryListBusiness(
        available ?: 0,
        returned ?: 0,
        collectionURI ?: "",
        items?.map { it.toDomain() } ?: emptyList()
    )
}

data class StorySummaryResponse(
    var resourcesURI: String?,
    var name: String?,
    var type: String?
) {
    fun toDomain() = StorySummaryBusiness(
        resourcesURI ?: "",
        name ?: "",
        type ?: ""
    )
}

data class ComicListResponse(
    var available: Int?,
    var returned: Int?,
    var collectionURI: String?,
    var items: List<ComicSummaryResponse>?
) {
    fun toDomain() = ComicListBusiness(
        available ?: 0,
        returned ?: 0,
        collectionURI ?: "",
        items?.map { it.toDomain() } ?: emptyList()
    )
}

data class ComicSummaryResponse(
    var resourceURI: String?,
    var name: String?
) {
    fun toDomain() = ComicSummaryBusiness(
        resourceURI ?: "",
        name ?: ""
    )
}

data class UrlResponse(
    var type: String?,
    var url: String?
) {
    fun toDomain() = UrlBusiness(
        type ?: "",
        url ?: ""
    )
}

data class ImageResponse(
    var path: String?,
    var extension: String?
) {
    fun toDomain() = ImageBusiness(
        path ?: "",
        extension?: ""
    )
}