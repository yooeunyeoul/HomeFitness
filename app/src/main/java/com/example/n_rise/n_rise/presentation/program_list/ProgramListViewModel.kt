package com.example.n_rise.n_rise.presentation.program_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.n_rise.n_rise.common.Resource
import com.example.n_rise.n_rise.domain.use_case.get_programs.GetProgramsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProgramListViewModel @Inject constructor(
    private val getProgramsUseCase: GetProgramsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(ProgramsListState())
    val state: State<ProgramsListState> = _state

    init {
        getPrograms()
    }

    private fun getPrograms() {
        getProgramsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {

                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {
//                    _state.value = state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}