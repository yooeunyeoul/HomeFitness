package com.example.n_rise.n_rise.domain.model

import android.net.Uri
import com.example.n_rise.n_rise.domain.util.ProgramStatus
import com.google.gson.Gson

data class Program(
    val id: Int=0,
    val image_url: String="", //썸네일
    val level: String = "",//난이도
    val average_minute: Int = 0, //운동 소요시간
    val effect: String = "", // 효과
    val coachName: String="", //코치 정보
    val category: String="", // 카테고리
    val title: String="",// 프로그램 제목
    val status: ProgramStatus = ProgramStatus.None, // 프로그램 상태]
) {
    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
}
