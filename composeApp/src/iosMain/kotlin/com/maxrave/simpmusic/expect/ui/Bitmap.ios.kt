package com.maxrave.simpmusic.expect.ui

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import coil3.Image
import coil3.BitmapImage

actual fun ImageBitmap.toByteArray(): ByteArray? = null

actual fun ImageBitmap.toPngByteArray(): ByteArray? = null

actual fun Image.toImageBitmap(): ImageBitmap {
    val bitmapImage = this as? BitmapImage
    return if (bitmapImage != null) {
        bitmapImage.bitmap.asComposeImageBitmap()
    } else {
        ImageBitmap(1, 1)
    }
}

actual fun ImageBitmap.toReadableBitmap(
    width: Int,
    height: Int,
): ImageBitmap = this
