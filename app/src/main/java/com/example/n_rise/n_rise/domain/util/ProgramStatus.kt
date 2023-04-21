package com.example.n_rise.n_rise.domain.util

sealed class ProgramStatus(val status: String) {
    object OnGoing : ProgramStatus(status = "ON_GOING")
    object Complete : ProgramStatus(status = "COMPLETED")
    object None : ProgramStatus(status = "")
}