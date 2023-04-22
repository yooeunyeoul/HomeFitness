package com.example.n_rise.n_rise.presentation.program_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.n_rise.presentation.program_list.components.ProgramCategoryWithCoachNameText
import com.example.n_rise.n_rise.presentation.program_list.components.ProgramImage16_9Ratio
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun ProgramDetailScreen(
    navController: NavController?,
    program: Program,
) {
    val scrollState = rememberScrollState()

    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
        ) {
            ProgramImage16_9Ratio(program = program)
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = program?.title ?: "",
                    style = nRiseTypography.h20,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                ProgramCategoryWithCoachNameText(program)
            }


        }
    }

}

@Preview
@Composable
fun previewDetailScreen() {
    ProgramDetailScreen(
        navController = null,
        program = Program(coachName = "코치 이름", category = "카테고리")
    )
}
