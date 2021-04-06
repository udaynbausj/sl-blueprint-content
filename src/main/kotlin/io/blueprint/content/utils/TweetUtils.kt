package io.blueprint.content.utils

import io.blueprint.content.constants.Constants
import io.blueprint.content.dto.TweetDto
import io.blueprint.content.enums.ClientEnum

class TweetUtils {

    companion object {

        fun validateTweetTextLength(text : String) : Boolean {

            if(text.length > Constants.getTweetTextLengthLimit()) {
                return false
            }
            return true
        }

        fun getClientTypeFromTweetDto(tweetDto: TweetDto) : ClientEnum {

            when (tweetDto.client) {
                ClientEnum.ANDROID.name -> {
                    return ClientEnum.ANDROID
                }

                ClientEnum.IOS.name -> {
                    return ClientEnum.IOS
                }

                ClientEnum.WEB.name -> {
                    return ClientEnum.WEB
                }

                else -> {
                    return ClientEnum.ANDROID
                }
            }

        }
    }

}