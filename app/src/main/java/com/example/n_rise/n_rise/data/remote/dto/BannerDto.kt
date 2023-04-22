package com.example.n_rise.n_rise.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerDto(
    val title: String,
    val description: String,
    val image_url: String
)
