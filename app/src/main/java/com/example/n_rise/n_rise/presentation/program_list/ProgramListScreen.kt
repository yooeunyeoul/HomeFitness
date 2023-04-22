package com.example.n_rise.n_rise.presentation.program_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.n_rise.n_rise.common.Constants
import com.example.n_rise.n_rise.presentation.Screen
import com.example.n_rise.n_rise.presentation.program_list.components.ProgramListItem

@Composable
fun ProgramListScreen(
    navController: NavController,
    viewModel: ProgramListViewModel = hiltViewModel()
) {
    val programs = viewModel.programPagingFlow.collectAsLazyPagingItems()
    val programState by viewModel.state.collectAsState()


    Box(Modifier.fillMaxSize()) {

        Column(Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
            }

            LazyColumn(
                Modifier
                    .fillMaxWidth()
            ) {
                items(programs) { program ->
                    ProgramListItem(onItemClick = { program ->
                        navController.navigate(Screen.ProgramDetailScreen.route + "?${Constants.PARAM_PROGRAM_ID}=${program?.id}")
                        viewModel.changeWatchingState(program)
                    }, program = program, isWatching = programState[program?.id] ?: false)
                }
            }

        }
    }

}