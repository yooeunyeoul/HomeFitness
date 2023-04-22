package com.example.n_rise.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.n_rise.R

val nRiseFontFamily =
    FontFamily(
        Font(R.font.notosans_kr_regular),
        Font(R.font.notosans_kr_bold)
    )
// Set of Material typography styles to start with
val nRiseTypography = Typography(
    defaultFontFamily = nRiseFontFamily,
    h20 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h18 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h16 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h12 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    body14 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body12 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
)



