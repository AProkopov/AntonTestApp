package com.example.antontestapp.mainscreen.data.remote.source_c

import com.google.gson.annotations.SerializedName

data class SourceCItemDto(
    @SerializedName("topLine")
    val topLine: String? = null,
    @SerializedName("subLine1")
    val subLine1: String? = null,
    @SerializedName("subLine2")
    val subLine2: String? = null,
    @SerializedName("image")
    val image: String? = null
)