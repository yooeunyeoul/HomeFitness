package com.example.n_rise.n_rise.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ProgramDao {

    @Upsert
    suspend fun upsertAll(programs: List<ProgramEntity>)

    @Query("SELECT * FROM programentity")
    fun pagingSource(): PagingSource<Int, ProgramEntity>

    @Query("DELETE FROM programentity")
    suspend fun clearAll()
}