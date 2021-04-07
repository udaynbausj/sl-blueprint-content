package io.blueprint.content.repositories

import io.blueprint.content.models.TweetModel
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface TweetRepository : CrudRepository<TweetModel,Long> {

    @Transactional(readOnly = false)
    @Query(value = "update tweet set status = 0 where id =:tweetId")
    fun changeTweetStatus(@Param(value = "tweetId") tweetId : Long) : TweetModel

}