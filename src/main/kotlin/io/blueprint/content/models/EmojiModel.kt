package io.blueprint.content.models

import javax.persistence.*

@Entity
@Table(name = "emoji")
class EmojiModel {
    @Id
    @GeneratedValue
    var userId: Int = 0

    @Column
    var type: Byte = 0

    @Column(name = "tweet_id")
    var tweetId: Long = 0
}