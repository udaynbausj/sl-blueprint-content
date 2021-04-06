package io.blueprint.content.repositories

import io.blueprint.content.models.TweetModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TweetRepository : CrudRepository<TweetModel,Long> {
}