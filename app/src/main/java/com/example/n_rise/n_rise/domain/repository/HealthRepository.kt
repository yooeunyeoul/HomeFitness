package com.example.n_rise.n_rise.domain.repository

import androidx.paging.PagingData
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.dto.BadgeDto
import com.example.n_rise.n_rise.data.remote.dto.BannerDto
import com.example.n_rise.n_rise.data.remote.dto.ProgramItemDto
import com.example.n_rise.n_rise.data.remote.dto.ProgramsDto
import com.example.n_rise.n_rise.domain.model.Program
import kotlinx.coroutines.flow.Flow

interface HealthRepository {

    fun getPrograms(): Flow<PagingData<ProgramEntity>>

    suspend fun getBanner(): BannerDto

    suspend fun getBadges(programIdList: List<Int>): BadgeDto

}