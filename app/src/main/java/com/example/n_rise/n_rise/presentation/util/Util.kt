package com.example.n_rise.n_rise.presentation.util

import com.example.n_rise.n_rise.domain.model.Program
import com.google.gson.JsonObject

fun JsonObject.toProgramModel():Program {
    return Program(
        image_url = get("image_url").asString,
        category = get("category").asString,
        title = get("title").asString,
        coachName = get("coachName").asString,
    )
}