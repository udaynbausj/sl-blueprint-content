package io.blueprint.content.controllers

import io.blueprint.content.dto.TweetDto
import io.blueprint.content.models.TweetModel
import io.blueprint.content.services.TweetService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tweet")
class TweetController constructor(@Autowired val tweetService: TweetService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/")
    fun createTweet(@RequestBody tweetDto: TweetDto) : TweetModel {
        logger.info("request received with body : {} ",tweetDto.toString())
        return tweetService.createTweet(tweetDto)
    }

    @DeleteMapping("/{tweetId}")
    fun deleteTweet(@PathVariable(name = "tweetId") tweetId : Long) : TweetModel {
        logger.info("request to delete tweet with id : {} received",tweetId)
        return tweetService.deleteTweet(tweetId)
    }

    @GetMapping("/{tweetId}")
    fun getTweet(@PathVariable(name = "tweetId") tweetId: Long) : TweetModel {
        logger.info("request to get tweet with id : {} received",tweetId)
        return tweetService.getTweet(tweetId)
    }

    @GetMapping("/user/{userId}")
    fun getPaginatedTweetByUserId(@PathVariable(name = "userId") userId: Long,
                                    @Param(value = "limit") limit:Int,
                                    @Param(value = "offset") offset:Int) : List<TweetModel> {
        logger.info("request to get tweets by userId : {}",userId)
        return tweetService.getPaginatedTweetsByUserId(userId,limit,offset)
    }

}