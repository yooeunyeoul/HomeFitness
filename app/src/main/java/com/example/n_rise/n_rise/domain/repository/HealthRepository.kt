package com.example.n_rise.n_rise.domain.repository

import com.example.n_rise.n_rise.data.data_source.remote.dto.BadgeDto
import com.example.n_rise.n_rise.data.data_source.remote.dto.BannerDto
import com.example.n_rise.n_rise.data.data_source.remote.dto.ProgramsDto

interface HealthRepository {

    suspend fun getPrograms(pageSize: Int, page: Int): ProgramsDto

    suspend fun getBanner(): BannerDto

    suspend fun getBadges(programIdList: List<Int>): BadgeDto

}