package com.example.n_rise.n_rise.data.data_source.remote.dto

class BadgeDto : ArrayList<BadgeDtoItem>()

fun BadgeDto.toMap(): Map<Int, String> {
    return associate { it.program_id to it.status }
}