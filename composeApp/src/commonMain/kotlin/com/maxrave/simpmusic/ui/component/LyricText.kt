package com.maxrave.simpmusic.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
fun isRtlText(text: String): Boolean {
    for (char in text) {
        val codePoint = char.code
        if (codePoint in 0x0590..0x08FF || codePoint in 0xFB50..0xFDFF || codePoint in 0xFE70..0xFEFF) {
            return true
        }
    }
    return false
}

@Composable
internal fun rememberLyricLayoutDirection(text: String): LayoutDirection =
    remember(text) {
        if (isRtlText(text)) LayoutDirection.Rtl else LayoutDirection.Ltr
    }

/**
 * A lyric and its subtitles share an edge, while each text keeps its own reading direction.
 * [alignmentText] is the original lyric when rendering a translation or romanization.
 */
@Composable
internal fun LyricText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    alignmentText: String = text,
    color: Color = Color.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
    softWrap: Boolean = true,
) {
    val alignmentDirection = rememberLyricLayoutDirection(alignmentText)
    val readingDirection = rememberLyricLayoutDirection(text)
    // Scope the marquee's direction to the text, without mirroring the surrounding player.
    CompositionLocalProvider(LocalLayoutDirection provides readingDirection) {
        Text(
            text = text,
            style = style.copy(textDirection = TextDirection.ContentOrLtr),
            modifier = modifier,
            textAlign = if (alignmentDirection == LayoutDirection.Rtl) TextAlign.Right else TextAlign.Left,
            color = color,
            maxLines = maxLines,
            softWrap = softWrap,
        )
    }
}
