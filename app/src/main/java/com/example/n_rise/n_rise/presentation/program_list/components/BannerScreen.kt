package com.example.n_rise.n_rise.presentation.program_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.n_rise.n_rise.domain.model.Banner
import com.example.n_rise.ui.theme.Gray_50
import com.example.n_rise.ui.theme.Gray_90
import com.example.n_rise.ui.theme.nRiseTypography

@Composable
fun BannerScreen(banner: Banner?) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.White)
            .padding(start = 24.dp), verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Text(text = banner?.title ?: "", style = nRiseTypography.h16, color = Gray_90)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = banner?.description ?: "", style = nRiseTypography.body12, color = Gray_50)
        }
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(banner?.imageUrl)
                .crossfade(true).build(),
            contentDescription = null,
            modifier = Modifier
                .size(width = 150.dp, height = 100.dp)

        )

    }
}

@Preview
@Composable
fun previewBannerScreen() {
    BannerScreen(
        banner = Banner(
            title = "타이틀",
            description = "설명",
            imageUrl = ""
        )
    )
}