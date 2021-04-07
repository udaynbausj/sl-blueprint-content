package io.blueprint.content.core

import io.blueprint.content.dto.TweetDto
import io.blueprint.content.enums.TweetStatusEnum
import io.blueprint.content.exceptions.TweetNotFoundException
import io.blueprint.content.exceptions.ValidationException
import io.blueprint.content.models.TweetModel
import io.blueprint.content.repositories.TweetRepository
import io.blueprint.content.services.HashtagService
import io.blueprint.content.services.TweetService
import io.blueprint.content.utils.TweetUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TweetServiceImpl constructor(@Autowired val tweetRepository: TweetRepository) : TweetService {

    override fun createTweet(tweetDto: TweetDto): TweetModel {

        if (!TweetUtils.validateTweetTextLength(tweetDto.text)) {
            throw ValidationException("Max length exceeded")
        }

        val tweetModel = buildTweetModel(tweetDto)
        return tweetRepository.save(tweetModel)

    }

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun deleteTweet(tweetId: Long): TweetModel {
        val isEmpty = tweetRepository.findById(tweetId).isEmpty

        if (isEmpty) {
            throw TweetNotFoundException("Tweet with given id is not present")
        }

        return tweetRepository.changeTweetStatus(tweetId)
    }

    fun findHashTags(text : String): List<String> {
        var len = text.length
        var i = 0
        var iter = 0

        val hashTagList = mutableListOf<String>()
        var tempString = ""

        while (len-- > 0) {
            if(text[iter] == '#') {
                i = iter
                tempString += text[i]
                i++
            } else if(text[iter] == ' ') {
                hashTagList.add(tempString)
                tempString = ""
            } else {
                tempString += text[i]
                i++
            }
            iter++
        }
        return hashTagList
    }


    fun buildTweetModel(tweetDto: TweetDto) : TweetModel {
        val tweetModel = TweetModel()
        tweetModel.clientType = TweetUtils
                                .getClientTypeFromTweetDto(tweetDto)
                                .ordinal.toByte()
        tweetModel.createdAt = Date()
        tweetModel.updatedAt = Date()
        tweetModel.parentTweetId = tweetDto.parentTweetId
        tweetModel.regionId = tweetDto.regionId
        tweetModel.text = tweetDto.text
        tweetModel.status = TweetStatusEnum.ACTIVE.ordinal.toByte()
        tweetModel.userId = tweetDto.userId

        return tweetModel
    }

}