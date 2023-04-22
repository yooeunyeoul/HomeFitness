package com.example.n_rise.n_rise.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ProgramEntity::class],
    version = 1
)
abstract class ProgramDatabase : RoomDatabase() {

    abstract val dao: ProgramDao

}