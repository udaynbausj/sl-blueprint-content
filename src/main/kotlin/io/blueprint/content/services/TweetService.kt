package io.blueprint.content.services

import io.blueprint.content.dto.TweetDto
import io.blueprint.content.models.TweetModel

interface TweetService {
    fun createTweet(tweetDto: TweetDto) : TweetModel
    fun deleteTweet(tweetId : Long) : TweetModel
    fun getTweet(tweetId: Long) : TweetModel
}