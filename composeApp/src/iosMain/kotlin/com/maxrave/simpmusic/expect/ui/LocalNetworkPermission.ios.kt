package com.maxrave.simpmusic.expect.ui

import androidx.compose.runtime.Composable

@Composable
actual fun rememberLocalNetworkPermission(): LocalNetworkPermissionRequester =
    object : LocalNetworkPermissionRequester {
        override fun requestIfNeeded(url: String) {}
    }
