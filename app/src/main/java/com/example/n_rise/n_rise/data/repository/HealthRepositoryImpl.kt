package com.example.n_rise.n_rise.data.repository

import com.example.n_rise.n_rise.data.data_source.remote.HealthApi
import com.example.n_rise.n_rise.data.data_source.remote.dto.BadgeDto
import com.example.n_rise.n_rise.data.data_source.remote.dto.BannerDto
import com.example.n_rise.n_rise.data.data_source.remote.dto.ProgramsDto
import com.example.n_rise.n_rise.domain.repository.HealthRepository
import javax.inject.Inject

class HealthRepositoryImpl @Inject constructor(
    private val api: HealthApi,
) : HealthRepository {
    override suspend fun getPrograms(pageSize: Int, page: Int): ProgramsDto {
        return api.getPrograms(pageSize = pageSize, page = page)
    }

    override suspend fun getBanner(): BannerDto {
        return api.getBanner()
    }

    override suspend fun getBadges(programIdList: List<Int>): BadgeDto {
        return api.getBadges(programIdList = programIdList)
    }


}