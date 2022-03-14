package com.example.antontestapp.mainscreen.data.remote.source_b

import com.google.gson.annotations.SerializedName

data class MetaDataDto(
    @SerializedName("this")
    val thisField: String? = null,
    @SerializedName("innerdata")
    val innerData: List<SourceBItemDto>? = null
)

data class SourceBItemDto(
    @SerializedName("articleId")
    val articleId: Int? = null,
    @SerializedName("articleWrapper")
    val articleWrapper: ArticleWrapperDto? = null,
    @SerializedName("picture")
    val picture: String? = null
)

data class ArticleWrapperDto(
    @SerializedName("header")
    val header: String? = null,
    @SerializedName("description")
    val description: String? = null
)