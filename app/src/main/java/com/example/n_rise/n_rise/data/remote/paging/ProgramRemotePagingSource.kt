package com.example.n_rise.n_rise.data.remote.paging
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.n_rise.n_rise.common.Constants.PAGE_SIZE
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.HealthApi
import com.example.n_rise.n_rise.data.remote.dto.toMap
import com.example.n_rise.n_rise.data.remote.dto.toProgramEntity


class ProgramRemotePagingSource(
    private val api: HealthApi
) : PagingSource<Int, ProgramEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProgramEntity> {
        return try {
            val next = params.key ?: 1

            val programs = api.getPrograms(pageSize = PAGE_SIZE, page = next)
            val badges = api.getBadges(programIdList = programs.map { it.id })
            val badgesMap = badges.toMap()
            val programList = programs.map { it.toProgramEntity(badgesMap) }
            LoadResult.Page(
                data = programList,
                prevKey = if (next == 1) null else next - 1,
                nextKey = if (programList.isEmpty()) {
                    null
                } else {
                    next.plus(1)
                }
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ProgramEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}