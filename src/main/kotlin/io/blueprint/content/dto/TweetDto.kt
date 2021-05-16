package io.blueprint.content.dto

import com.google.gson.Gson

class TweetDto {
    val userId : Long = 0
    val text : String = ""
    val client : String = ""
    val regionId : Int = 0
    val parentTweetId : Long? = null

    override fun toString(): String {
        return Gson().toJson(this)
    }


}
