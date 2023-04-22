package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.n_rise.R
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.hot),
        style = nRiseTypography.h18,
        color = Color.White,
        modifier = modifier
    )
}