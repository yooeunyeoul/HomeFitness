package com.example.n_rise.n_rise.presentation.program_list

import com.example.n_rise.n_rise.domain.model.Program

data class ProgramsListState(
    val programs : List<Program> = emptyList(),
    val isLoading : Boolean = false,
    val error: String = "",
)
