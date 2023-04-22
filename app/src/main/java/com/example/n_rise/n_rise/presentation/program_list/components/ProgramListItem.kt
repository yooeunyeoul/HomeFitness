package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.n_rise.domain.util.ProgramStatus
import com.example.n_rise.n_rise.presentation.program_list.ProgramState

@Composable
fun ProgramListItem(
    program: Program? = null,
    onItemClick: (Program?) -> Unit,
    isWatching : Boolean = false
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if(isWatching) Color.Gray else Color.White)
            .height(300.dp)
            .clickable { onItemClick(program) }
            .padding(22.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(program?.image_url)
                .crossfade(true).build(),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            modifier = Modifier
                .size(86.dp)
                .clip(CircleShape)
        )
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