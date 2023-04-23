package com.example.n_rise.n_rise.domain.use_case

import com.example.n_rise.n_rise.common.Resource
import com.example.n_rise.n_rise.data.mappers.toBanner
import com.example.n_rise.n_rise.domain.model.Banner
import com.example.n_rise.n_rise.domain.repository.HealthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBannerUseCase @Inject constructor(
    private val repository: HealthRepository
) {
    operator fun invoke(): Flow<Resource<Banner>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getBanner()
            emit(Resource.Success(result.toBanner()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: e.localizedMessage))
        }
    }
}