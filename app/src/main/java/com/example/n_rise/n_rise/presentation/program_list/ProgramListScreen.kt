package com.example.n_rise.n_rise.presentation.program_list

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.n_rise.R
import com.example.n_rise.n_rise.common.Constants
import com.example.n_rise.n_rise.domain.model.Banner
import com.example.n_rise.n_rise.presentation.Screen
import com.example.n_rise.n_rise.presentation.program_list.components.BannerScreen
import com.example.n_rise.n_rise.presentation.program_list.components.CategoryScreen
import com.example.n_rise.n_rise.presentation.program_list.components.ProgramHeaderScreen
import com.example.n_rise.n_rise.presentation.program_list.components.ProgramListItem
import com.example.n_rise.ui.theme.Gray_50
import com.example.n_rise.ui.theme.Gray_90
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun ProgramListScreen(
    navController: NavController,
    viewModel: ProgramListViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val programs = viewModel.programPagingFlow.collectAsLazyPagingItems()
    val programState by viewModel.state.collectAsState()
    val banner by viewModel.bannerFlow.collectAsState()
    LaunchedEffect(key1 = programs.loadState) {
        if (programs.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (programs.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }


    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {

        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            ProgramHeaderScreen()

            if (programs.loadState.refresh is LoadState.Loading) {
                CircularProgressIndicator()
            } else {
                Column(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                    }

                    LazyColumn(
                        Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(bottom = 18.dp)
                    ) {

                        itemsIndexed(programs) { index, program ->
                            if (index == 0) {
                                BannerScreen(banner.data)
                                Spacer(modifier = Modifier.height(24.dp))
                                CategoryScreen(
                                    modifier = Modifier
                                        .padding(start = 16.dp)
                                        .align(
                                            Alignment.Start
                                        )
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                            }

                            ProgramListItem(
                                onItemClick = { program ->
                                    navController.navigate(Screen.ProgramDetailScreen.route + "?${Constants.PARAM_PROGRAM_ID}=${program?.id}")
                                    viewModel.changeWatchingState(program)
                                },
                                program = program,
                                isWatching = programState[program?.id] ?: false,
                                modifier = Modifier.align(
                                    Alignment.CenterHorizontally
                                )
                            )
                        }
                        item {
                            if (programs.loadState.append is LoadState.Loading) {
                                CircularProgressIndicator()
                            }
                        }
                    }

                }

            }


        }


    }

}

