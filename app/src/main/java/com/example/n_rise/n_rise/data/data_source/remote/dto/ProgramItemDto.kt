package com.example.n_rise.n_rise.data.data_source.remote.dto

data class ProgramItemDto(
    val id: Int,//프로그램 고유 id
    val image_url: String, //썸네일
    val level: String,//난이도
    val average_minute: Int, //운동 소요시간
    val effect: String, // 효과
    val coach: Coach, //코치 정보
    val category: String, // 카테고리
    val title: String // 프로그램 제목
)

