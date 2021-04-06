package io.blueprint.content.controllers

import io.blueprint.content.dto.TweetDto
import io.blueprint.content.models.TweetModel
import io.blueprint.content.services.TweetService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tweet")
class TweetController constructor(@Autowired var tweetService: TweetService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/")
    fun createTweet(@RequestBody tweetDto: TweetDto) : TweetModel {
        logger.info("request received with body : {} ",tweetDto.toString())
        return tweetService.createTweet(tweetDto)
    }

}