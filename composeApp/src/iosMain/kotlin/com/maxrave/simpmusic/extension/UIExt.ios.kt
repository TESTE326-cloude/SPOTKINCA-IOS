package com.maxrave.simpmusic.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import com.maxrave.domain.data.model.ui.ScreenSizeInfo

@Composable
actual fun getScreenSizeInfo(): ScreenSizeInfo {
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val size = windowInfo.containerSize
    return remember(size, density) {
        val wPx = size.width
        val hPx = size.height
        val wDp = with(density) { wPx.toDp().value.toInt() }
        val hDp = with(density) { hPx.toDp().value.toInt() }
        ScreenSizeInfo(
            hDP = hDp,
            wDP = wDp,
            hPX = hPx,
            wPX = wPx,
        )
    }
}

@Composable
actual fun KeepScreenOn() {}

@Composable
actual fun rememberIsInPipMode(): Boolean = false
