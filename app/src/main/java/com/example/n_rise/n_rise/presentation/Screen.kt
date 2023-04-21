package com.example.n_rise.n_rise.presentation

sealed class Screen(val route: String){
    object ProgramListScreen : Screen("program_list")
    object ProgramDetailScreen : Screen("program_detail_screen")
}
