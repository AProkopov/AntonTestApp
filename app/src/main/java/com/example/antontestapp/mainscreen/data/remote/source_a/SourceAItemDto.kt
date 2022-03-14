package com.example.antontestapp.mainscreen.data.remote.source_a

import com.google.gson.annotations.SerializedName

data class SourceAItemDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("imageUrl")
    val imageUrl: String? = null,
)