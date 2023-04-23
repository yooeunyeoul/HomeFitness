package com.example.n_rise.n_rise.domain.use_case

import androidx.paging.PagingData
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.domain.repository.HealthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProgramsUseCase @Inject constructor(
    private val repository: HealthRepository
) {
    operator fun invoke(): Flow<PagingData<ProgramEntity>> {
        return repository.getPrograms()
    }
}