package io.blueprint.content.core

import io.blueprint.content.dto.TweetDto
import io.blueprint.content.models.TweetModel
import io.blueprint.content.services.TweetService
import org.springframework.stereotype.Service

@Service
class TweetServiceImpl : TweetService {

    override fun createTweet(tweetDto: TweetDto): TweetModel {
        TODO("Not yet implemented")
    }

    override fun updateTweet(): TweetModel {
        TODO("Not yet implemented")
    }

    override fun deleteTweet() {
        TODO("Not yet implemented")
    }
}