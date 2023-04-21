package com.example.n_rise.n_rise.domain.use_case.get_programs

import com.example.n_rise.n_rise.common.Resource
import com.example.n_rise.n_rise.data.data_source.remote.dto.toMap
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.n_rise.domain.model.toProgram
import com.example.n_rise.n_rise.domain.repository.HealthRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProgramsUseCase @Inject constructor(
    private val repository: HealthRepository
) {
    operator fun invoke(): Flow<Resource<List<Program>>> =
        callbackFlow {
            try {
                trySend(Resource.Loading())
                val programs = repository.getPrograms(pageSize = 10, page = 1)
                println("programs$programs")
                val badges = repository.getBadges(programIdList = programs.map { it.id })
                val badgesMap = badges.toMap()
                val programList = programs.map { it.toProgram(badgesMap) }
                println(programList)
            } catch (e: HttpException) {
                trySend(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                trySend(Resource.Error("Check your internet connection."))
            } catch (e: Exception) {
                trySend(Resource.Error(e.message ?: e.localizedMessage))
            }
            awaitClose()
        }
}