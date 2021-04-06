package io.blueprint.content.core

import io.blueprint.content.dto.TweetDto
import io.blueprint.content.exceptions.ValidationException
import io.blueprint.content.models.TweetModel
import io.blueprint.content.services.TweetService
import io.blueprint.content.utils.TweetUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TweetServiceImpl : TweetService {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun createTweet(tweetDto: TweetDto): TweetModel {

        val isValid = TweetUtils.validateTweetTextLength(tweetDto.text)

        if (!isValid) {
            throw ValidationException("Max length exceeded")
        }

        return TweetModel()
    }

    override fun updateTweet(): TweetModel {
        TODO("Not yet implemented")
    }

    override fun deleteTweet() {
        TODO("Not yet implemented")
    }

}