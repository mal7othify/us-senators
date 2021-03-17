package com.example.ussenators.domain.model

import com.google.gson.annotations.SerializedName

class Object {
    @SerializedName("meta")
    val meta: Meta? = null

    @SerializedName("objects")
    val senator: List<Senator>? = null
}
