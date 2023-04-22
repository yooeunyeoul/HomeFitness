package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.n_rise.R
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun ProgramHeaderScreen() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(44.dp)){
        Text(
            text = stringResource(R.string.program),
            style = nRiseTypography.h18,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center),
        )

    }
}

@Preview
@Composable
fun prevHeaderScreen() {
    ProgramHeaderScreen()
}