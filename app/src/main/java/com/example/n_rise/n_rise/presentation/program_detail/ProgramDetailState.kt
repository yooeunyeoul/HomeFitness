package com.example.n_rise.n_rise.presentation.program_detail

import com.example.n_rise.n_rise.domain.model.Program

data class ProgramDetailState(
    val isLoading: Boolean = false,
    val program: Program? = null,
    val error: String = ""
) {
}