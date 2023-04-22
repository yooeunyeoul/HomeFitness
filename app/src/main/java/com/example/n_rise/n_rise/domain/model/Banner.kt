package com.example.n_rise.n_rise.domain.model

import kotlinx.serialization.SerialName

data class Banner(
    val title: String,
    val description: String,
    val imageUrl: String
)