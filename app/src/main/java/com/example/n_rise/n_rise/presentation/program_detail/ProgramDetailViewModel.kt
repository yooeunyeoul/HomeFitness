package com.example.n_rise.n_rise.presentation.program_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.n_rise.n_rise.common.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProgramDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(ProgramDetailState())
    val state: State<ProgramDetailState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_PROGRAM_ID)?.let { programId ->
            getProgram(programId)
        }
    }

    private fun getProgram(programId: Int) {

    }





}
