package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.n_rise.domain.util.ProgramStatus
import com.example.n_rise.n_rise.presentation.program_list.ProgramState
import com.example.n_rise.ui.theme.Gray_40
import com.example.n_rise.ui.theme.Gray_80
import com.example.n_rise.ui.theme.Gray_90
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun ProgramListItem(
    program: Program? = null,
    onItemClick: (Program?) -> Unit,
    isWatching: Boolean = false,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick(program) }
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
    ) {
        Column(
            Modifier
                .clip(RoundedCornerShape(7.6.dp))
        ) {
            Box(
                Modifier
                    .background(color = if (isWatching) Gray_90 else Color.Transparent)
                    .alpha(if (isWatching) 0.6f else 1.0f)
            ) {
                ProgramImage16_9Ratio(program = program)
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Gray_80)
                    .padding(start = 12.dp, end = 16.dp, bottom = 8.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "${program?.level ?: ""} · 평균 ${program?.average_minute ?: ""}분 · ${program?.effect ?: ""}",
                        style = nRiseTypography.body14,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    ProgramCategoryWithCoachNameText(program)
                }

                Spacer(modifier = Modifier.weight(1f))
                if (program != null) {
                    when (program.status) {
                        ProgramStatus.Complete -> OnCompleteChip()
                        ProgramStatus.None -> {}
                        ProgramStatus.OnGoing -> OnGoingChip()
                    }
                }


            }

        }
    }
}


@Preview
@Composable
fun PreviewProgramItem() {
    ProgramListItem(
        program = Program(
            image_url = "",
            level = "초보",
            average_minute = 15,
            effect = "효과",
            coachName = "코치이름",
            category = "카테고리",
            title = "타이틀",
            status = ProgramStatus.Complete,
            id = 1
        ), isWatching = false, onItemClick = {

        }
    )
}