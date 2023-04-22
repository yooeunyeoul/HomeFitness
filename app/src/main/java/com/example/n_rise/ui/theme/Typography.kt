package com.example.n_rise.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import javax.annotation.concurrent.Immutable

@Immutable
class Typography internal constructor(
    val h20 : TextStyle,
    val h18 : TextStyle,
    val h16 : TextStyle,
    val h12 : TextStyle,
    val body14 : TextStyle,
    val body12 : TextStyle
) {
    constructor(
        defaultFontFamily: FontFamily = FontFamily.Default,
        h20: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        ),
        h18: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        h16: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        ),
        h12: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
        ),
        body14: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        ),
        body12: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
        )
    ) : this(
        h20 = h20.withDefaultFontFamily(defaultFontFamily),
        h18 = h18.withDefaultFontFamily(defaultFontFamily),
        h16 = h16.withDefaultFontFamily(defaultFontFamily),
        h12 = h12.withDefaultFontFamily(defaultFontFamily),
        body14 = body14.withDefaultFontFamily(defaultFontFamily),
        body12 = body12.withDefaultFontFamily(defaultFontFamily)
    )
}


/**
 * @return [this] if there is a [FontFamily] defined, otherwise copies [this] with [default] as
 * the [FontFamily].
 */
private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}