package io.blueprint.content.core

import io.blueprint.content.constants.Constants
import io.blueprint.content.dto.TweetDto
import io.blueprint.content.enums.TweetStatusEnum
import io.blueprint.content.exceptions.TweetNotFoundException
import io.blueprint.content.exceptions.ValidationException
import io.blueprint.content.models.TweetModel
import io.blueprint.content.repositories.TweetRepository
import io.blueprint.content.services.KafkaService
import io.blueprint.content.services.TweetService
import io.blueprint.content.utils.TweetUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TweetServiceImpl constructor(@Autowired val tweetRepository: TweetRepository,
@Autowired val kafkaService: KafkaService ) : TweetService {

    override fun createTweet(tweetDto: TweetDto): TweetModel {

        if (!TweetUtils.validateTweetTextLength(tweetDto.text)) {
            throw ValidationException("Max length exceeded")
        }

        val tweetModel = buildTweetModel(tweetDto)
        kafkaService.sendMessage(Constants.getTweetTopicName(),tweetModel.toString())
        return tweetRepository.save(tweetModel)

    }

    override fun deleteTweet(tweetId: Long): TweetModel {
        val isEmpty = tweetRepository.findById(tweetId).isEmpty

        if (isEmpty) {
            throw TweetNotFoundException("Tweet with given id is not present")
        }

        val tweetModel = tweetRepository.changeTweetStatus(tweetId)
        kafkaService.sendMessage(Constants.getTweetTopicName(),tweetModel)
        return tweetModel
    }

    override fun getTweet(tweetId: Long): TweetModel {

        val result = tweetRepository.findById(tweetId)

        if (result.isEmpty) {
            throw TweetNotFoundException("Tweet with given id is not present")
        }

        return result.get()
    }

    override fun getPaginatedTweetsByUserId(userId: Long,limit: Int,offset: Int): List<TweetModel> {
        return tweetRepository.getTweetModelsByUserId(userId,limit,offset)
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