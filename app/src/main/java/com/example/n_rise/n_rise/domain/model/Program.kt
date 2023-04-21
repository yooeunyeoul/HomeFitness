package com.example.n_rise.n_rise.domain.model

import com.example.n_rise.n_rise.data.data_source.remote.dto.Coach
import com.example.n_rise.n_rise.data.data_source.remote.dto.ProgramItemDto
import com.example.n_rise.n_rise.data.data_source.remote.dto.ProgramsDto
import com.example.n_rise.n_rise.domain.util.ProgramStatus

data class Program(
    val image_url: String, //썸네일
    val level: String,//난이도
    val average_minute: Int, //운동 소요시간
    val effect: String, // 효과
    val coachName: String, //코치 정보
    val category: String, // 카테고리
    val title: String,// 프로그램 제목
    val status: ProgramStatus // 프로그램 상태
)

fun ProgramItemDto.toProgram(badgeIdMap : Map<Int,String>):Program{
    return Program(
        image_url = image_url,
        level = level,
        average_minute = average_minute,
        effect = effect,
        coachName = coach.name,
        category = category,
        title = title,
        status = when (badgeIdMap[id]) {
            "COMPLETED"->{
                ProgramStatus.Complete
            }
            "ON_GOING"->{
                ProgramStatus.OnGoing
            }
            else->{
                ProgramStatus.None
            }
        }

    )
}

