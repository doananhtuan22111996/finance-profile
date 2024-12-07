package vn.finance.profile.presentation.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vn.finance.profile.api.ProfileApi
import vn.finance.profile.presentation.PATH
import vn.finance.profile.presentation.ui.ProfileView as Page

class ProfileApiImpl : ProfileApi {
    override val path: String
        get() = PATH

    @Composable
    override fun ProfileView(modifier: Modifier) {
        Page(modifier = modifier)
    }
}