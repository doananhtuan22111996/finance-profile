package vn.finance.profile.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface ProfileApi {

    val path: String

    @Composable
    fun ProfileView(modifier: Modifier)
}