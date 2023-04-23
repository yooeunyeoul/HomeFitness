package com.example.n_rise.n_rise.data.mappers

import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.dto.BadgeDto
import com.example.n_rise.n_rise.data.remote.dto.BannerDto
import com.example.n_rise.n_rise.data.remote.dto.ProgramItemDto
import com.example.n_rise.n_rise.domain.model.Banner
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.n_rise.domain.util.ProgramStatus

fun BadgeDto.toMap(): Map<Int, String> {
    return associate { it.program_id to it.status }
}

fun ProgramItemDto.toProgramEntity(badgeIdMap: Map<Int, String>): ProgramEntity {
    return ProgramEntity(
        id = id,
        image_url = image_url,
        level = level,
        average_minute = average_minute,
        effect = effect,
        coachName = coach.name,
        category = category,
        title = title,
        status = badgeIdMap[id]
    )
}

fun ProgramEntity.toProgram(): Program {
    return Program(
        id = id,
        image_url = image_url,
        level = level,
        average_minute = average_minute,
        effect = effect,
        coachName = coachName,
        category = category,
        title = title,
        status = when (status) {
            "COMPLETED" -> {
                ProgramStatus.Complete
            }

            "ON_GOING" -> {
                ProgramStatus.OnGoing
            }

            else -> {
                ProgramStatus.None
            }
        }
    )
}

fun BannerDto.toBanner(): Banner {
    return Banner(
        title = title,
        description = description,
        imageUrl = image_url
    )
}
