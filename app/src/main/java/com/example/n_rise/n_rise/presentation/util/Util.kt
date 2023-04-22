package com.example.n_rise.n_rise.presentation.util

import com.example.n_rise.n_rise.domain.model.Program
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

fun JsonObject.toProgramModel(): Program {
    return Program(
        image_url = get("image_url").asString,
        category = get("category").asString,
        title = get("title").asString,
        coachName = get("coachName").asString,
    )
}

inline fun <reified T> T.toEncodeUrl(block: (String) -> Unit):String {
    val gson = Gson()
    val objectString = gson.toJson(this, T::class.java)
    val encodeUrl = URLEncoder.encode(
        objectString,
        StandardCharsets.UTF_8.toString()
    )
    block(encodeUrl)
    return encodeUrl
}

