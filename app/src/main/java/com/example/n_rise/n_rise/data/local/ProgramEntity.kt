package com.example.n_rise.n_rise.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.n_rise.n_rise.domain.util.ProgramStatus

@Entity
data class ProgramEntity(
    @PrimaryKey
    val id :Int,
    val image_url: String, //썸네일
    val level: String,//난이도
    val average_minute: Int, //운동 소요시간
    val effect: String, // 효과
    val coachName: String, //코치 정보
    val category: String, // 카테고리
    val title: String,// 프로그램 제목
    val status: String? // 프로그램 상태
)
