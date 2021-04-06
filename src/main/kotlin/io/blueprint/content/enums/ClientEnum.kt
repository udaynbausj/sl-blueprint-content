package io.blueprint.content.enums

enum class ClientEnum {
    ANDROID {
        override fun getValue() = "ANDROID"
    },
    IOS {
        override fun getValue() = "IOS"
    },
    WEB {
        override fun getValue() = "WEB"
    };

    abstract fun getValue(): String

}