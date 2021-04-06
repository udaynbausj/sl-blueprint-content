package io.blueprint.content.services

interface HashtagService {
    fun saveHashTags(hashTagList : List<String>)
    fun fetchTrendingHashTags(region : Int) : List<String>
}