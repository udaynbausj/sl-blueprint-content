package io.blueprint.content.core

import io.blueprint.content.services.HashtagService
import org.springframework.stereotype.Service

@Service
class HashtagServiceImpl : HashtagService {

    override fun saveHashTags(hashTagList: List<String>) {
        TODO("Not yet implemented")
    }

    override fun fetchTrendingHashTags(region: Int): List<String> {
        TODO("Not yet implemented")
    }
}