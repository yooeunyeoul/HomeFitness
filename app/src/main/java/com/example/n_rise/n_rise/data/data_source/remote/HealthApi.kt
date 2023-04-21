package com.example.n_rise.n_rise.data.data_source.remote

import com.example.n_rise.n_rise.data.data_source.remote.dto.BadgeDto
import com.example.n_rise.n_rise.data.data_source.remote.dto.BannerDto
import com.example.n_rise.n_rise.data.data_source.remote.dto.ProgramsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HealthApi {
    @GET("programs")
    suspend fun getPrograms(
        @Query("page_size") pageSize: Int,
        @Query("page") page: Int,
    ): ProgramsDto

    @GET("banner")
    suspend fun getBanner(): BannerDto

    @GET("badges")
    suspend fun getBadges(
        @Query("id") programIdList: List<Int>,
    ): BadgeDto
}