package io.blueprint.content.utils

import io.blueprint.content.constants.Constants

class TweetUtils {

    companion object {

        fun validateTweetTextLength(text : String) : Boolean {

            if(text.length > Constants.getTweetTextLengthLimit()) {
                return false
            }
            return true
        }
    }

}