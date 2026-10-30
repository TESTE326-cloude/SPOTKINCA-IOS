package com.maxrave.simpmusic.expect.ui

import androidx.compose.runtime.Composable

@Composable
actual fun rememberSaveImagePermission(onResult: (granted: Boolean) -> Unit): SaveImagePermissionRequester =
    object : SaveImagePermissionRequester {
        override fun requestIfNeeded() {
            onResult(true)
        }
    }
