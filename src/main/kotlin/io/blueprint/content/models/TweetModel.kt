package io.blueprint.content.models

import com.google.gson.Gson
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tweet")
class TweetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column
    var text:String = ""

    @Column(name = "user_id")
    var userId: Long = 0

    @Column(name = "client_type")
    var clientType: Byte = 0

    @Column(name = "parent_tweet_id")
    var parentTweetId: Long? = 0

    @Column(name = "region_id")
    var regionId: Int = 0

    @Column
    var status: Byte = 0

    @Column(name = "created_at")
    var createdAt: Date? = null

    @Column(name = "updated_at")
    var updatedAt: Date? = null

    override fun toString(): String {
        return Gson().toJson(this)
    }


}