package com.example.n_rise.n_rise.presentation.program_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.n_rise.n_rise.common.Resource
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.dto.toProgram
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.n_rise.domain.use_case.GetBannerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProgramListViewModel @Inject constructor(
    pager: Pager<Int, ProgramEntity>,
    private val getBannerUseCase: GetBannerUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(hashMapOf<Int, Boolean>())
    val state = _state.asStateFlow()

    val programPagingFlow = pager.flow
        .map { programEntity ->

            val program = programEntity.map {
                _state.value[it.id] = false
                it.toProgram()
            }
            program
        }
        .cachedIn(viewModelScope)

    val bannerFlow =
        getBannerUseCase().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Resource.Loading()
        )

    fun changeWatchingState(program: Program?) {
        _state.value[program?.id ?: 0] = true
    }


}