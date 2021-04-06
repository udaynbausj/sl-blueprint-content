package io.blueprint.content.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class EmojiModel {
    @Id
    @GeneratedValue
    var userId: Int = 0
    var type: Byte = 0
    var tweetId: Long = 0
}