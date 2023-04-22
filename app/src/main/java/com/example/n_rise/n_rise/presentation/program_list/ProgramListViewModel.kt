package com.example.n_rise.n_rise.presentation.program_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.dto.toProgram
import com.example.n_rise.n_rise.domain.model.Program
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ProgramListViewModel @Inject constructor(
    pager: Pager<Int, ProgramEntity>
) : ViewModel() {
    private val _state = MutableStateFlow(hashMapOf<Int, Boolean>())
    val state = _state.asStateFlow()

    val programPagingFlow = pager.flow
        .map { programEntity ->

            val ddd = programEntity.map {
                _state.value[it.id] = false
                it.toProgram()
            }
            ddd
        }
        .cachedIn(viewModelScope)

    init {

    }

    fun changeWatchingState(program: Program?) {
        _state.value[program?.id ?: 0] = true
    }


}