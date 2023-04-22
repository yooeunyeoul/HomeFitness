package com.example.n_rise.n_rise.presentation.program_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.n_rise.n_rise.common.Resource
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.dto.toProgram
import com.example.n_rise.n_rise.domain.model.Program
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProgramListViewModel @Inject constructor(
    pager: Pager<Int, ProgramEntity>
) : ViewModel() {
    private val _state = mutableStateOf(ProgramsListState())
    val state: State<ProgramsListState> = _state


    val programPagingFlow = pager.flow
        .map { programEntity ->
            programEntity.map { it.toProgram() }
        }
        .cachedIn(viewModelScope)

    init {

    }


}