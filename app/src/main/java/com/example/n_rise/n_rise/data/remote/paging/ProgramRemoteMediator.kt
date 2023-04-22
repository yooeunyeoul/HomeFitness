package com.example.n_rise.n_rise.data.remote.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.n_rise.n_rise.data.local.ProgramDatabase
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.HealthApi
import com.example.n_rise.n_rise.data.remote.dto.toMap
import com.example.n_rise.n_rise.data.remote.dto.toProgramEntity
import kotlinx.coroutines.delay
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class ProgramRemoteMediator(
    private val programDb: ProgramDatabase,
    private val api: HealthApi
) : RemoteMediator<Int, ProgramEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ProgramEntity>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        println("앵커" + state.anchorPosition)
                        if (state.pages.isNotEmpty()) {
                            val currentPageSize = state.pages.map { it.data.size }.sum()
                            if (currentPageSize % state.config.pageSize != 0) {
                                return MediatorResult.Success(endOfPaginationReached = true)
                            } else {
                                (currentPageSize / state.config.pageSize) + 1
                            }
                        } else {
                            return MediatorResult.Success(endOfPaginationReached = true)
                        }

                    }
                }
            }

            val programs = api.getPrograms(pageSize = state.config.pageSize, page = page)
            val badges = api.getBadges(programIdList = programs.map { it.id })
            val badgesMap = badges.toMap()
            val programList = programs.map { it.toProgramEntity(badgesMap) }
            programDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    programDb.dao.clearAll()
                }
                programDb.dao.upsertAll(programList)
            }


            MediatorResult.Success(endOfPaginationReached = programList.size % 10 != 0)

        } catch (e: HttpException) {
            MediatorResult.Error(e)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}