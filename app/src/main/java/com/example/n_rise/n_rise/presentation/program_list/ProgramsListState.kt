package com.example.n_rise.n_rise.presentation.program_list

import com.example.n_rise.n_rise.domain.model.Program

data class ProgramState(
    val programId : Int=0,
    val isWatching : Boolean = false
)
