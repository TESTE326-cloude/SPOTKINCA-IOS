package com.maxrave.simpmusic.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.maxrave.domain.data.model.ui.ScreenSizeInfo

@Composable
actual fun getScreenSizeInfo(): ScreenSizeInfo {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    return remember(configuration) {
        val wDp = configuration.screenWidthDp
        val hDp = configuration.screenHeightDp
        ScreenSizeInfo(
            hDP = hDp,
            wDP = wDp,
            hPX = with(density) { hDp.dp.roundToPx() },
            wPX = with(density) { wDp.dp.roundToPx() },
        )
    }
}

@Composable
actual fun KeepScreenOn() {}

@Composable
actual fun rememberIsInPipMode(): Boolean = false
