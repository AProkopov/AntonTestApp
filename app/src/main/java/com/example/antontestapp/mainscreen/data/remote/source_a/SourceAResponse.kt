package com.example.antontestapp.mainscreen.data.remote.source_a

import com.google.gson.annotations.SerializedName

data class SourceAResponse(
    @SerializedName("stories")
    val stories: List<SourceAItemDto>? = emptyList()
)