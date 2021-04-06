package io.blueprint.content.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class TweetModel {
    @Id
    @GeneratedValue
    var id: Long = 0
    var text:String = ""
    var userId: Long = 0
    var clientType: Byte = 0
    var parentTweetId: Long? = 0
    var regionId: Int = 0
    var status: Byte = 0
    var createdAt: Date? = null
    var updatedAt: Date? = null
}