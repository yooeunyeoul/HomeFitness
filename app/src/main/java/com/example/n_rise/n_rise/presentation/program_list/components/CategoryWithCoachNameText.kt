package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.ui.theme.Gray_40
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun ProgramCategoryWithCoachNameText(program: Program?) {
    Text(
        text = "${program?.category}︱${program?.coachName}",
        style = nRiseTypography.body12,
        color = Gray_40
    )
}