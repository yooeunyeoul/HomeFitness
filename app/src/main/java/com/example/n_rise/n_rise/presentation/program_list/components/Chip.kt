package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.n_rise.R
import com.example.n_rise.ui.theme.Quat_Blue
import com.example.n_rise.ui.theme.Quat_Pink_50
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun OnCompleteChip() {
    Card(
        modifier = Modifier
            .border(width = 1.dp, color = Quat_Pink_50, shape = RoundedCornerShape(24.dp))

    ) {
        Text(
            text = stringResource(R.string.on_going),
            style = nRiseTypography.h12,
            color = Quat_Pink_50,
            modifier = Modifier
                .background(color = Color.Black)
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
        )
    }
}

@Composable
fun OnGoingChip() {
    Card(
        modifier = Modifier
            .border(width = 1.dp, color = Quat_Blue, shape = RoundedCornerShape(24.dp))
    ) {
        Text(
            text = stringResource(R.string.complete),
            style = nRiseTypography.h12,
            color = Quat_Blue,
            modifier = Modifier
                .background(color = Color.Black)
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)

        )
    }
}

@Preview
@Composable
fun previewOnCompleteChip() {
    OnCompleteChip()

}

@Preview
@Composable
fun previewOnGoingChip() {
    OnGoingChip()

}