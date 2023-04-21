package com.example.n_rise.n_rise.data.data_source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerDto(
    val title: String,
    val description: String,
    @SerialName("image_url")
    val imageUrl: String
)
