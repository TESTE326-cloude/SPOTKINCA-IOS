package com.maxrave.simpmusic.expect.ui

import androidx.compose.ui.graphics.ImageBitmap
import coil3.Image
import coil3.toBitmap

actual fun ImageBitmap.toByteArray(): ByteArray? = null

actual fun ImageBitmap.toPngByteArray(): ByteArray? = null

actual fun Image.toImageBitmap(): ImageBitmap = this.toBitmap().asImageBitmap()

actual fun ImageBitmap.toReadableBitmap(
    width: Int,
    height: Int,
): ImageBitmap = this
