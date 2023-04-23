package com.example.n_rise.n_rise.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.n_rise.n_rise.common.Constants
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.HealthApi
import com.example.n_rise.n_rise.data.remote.dto.BadgeDto
import com.example.n_rise.n_rise.data.remote.dto.BannerDto
import com.example.n_rise.n_rise.data.remote.dto.ProgramItemDto
import com.example.n_rise.n_rise.data.remote.dto.ProgramsDto
import com.example.n_rise.n_rise.data.remote.paging.ProgramRemotePagingSource
import com.example.n_rise.n_rise.domain.repository.HealthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HealthRepositoryImpl @Inject constructor(
    private val api: HealthApi,
) : HealthRepository {
    override fun getPrograms(): Flow<PagingData<ProgramEntity>> {
        return Pager(config = PagingConfig(pageSize = Constants.PAGE_SIZE)) {
            ProgramRemotePagingSource(api)
        }.flow
    }

    override suspend fun getBanner(): BannerDto {
        return api.getBanner()
    }

    override suspend fun getBadges(programIdList: List<Int>): BadgeDto {
        return api.getBadges(programIdList = programIdList)
    }


}