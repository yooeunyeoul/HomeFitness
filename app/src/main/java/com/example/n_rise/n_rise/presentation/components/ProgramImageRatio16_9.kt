package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.n_rise.n_rise.domain.model.Program

@Composable
fun ProgramImage16_9Ratio(program:Program?) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(program?.image_url)
            .crossfade(true).build(),
        contentScale = ContentScale.FillWidth,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
    )

}