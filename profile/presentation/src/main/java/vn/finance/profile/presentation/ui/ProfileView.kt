package vn.finance.profile.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vn.core.composex.uikit.alert.AlertExceptionDialogComponent
import vn.core.composex.uikit.loading.FullScreenLoadingDialogComponent
import vn.finance.profile.presentation.R
import vn.finance.profile.presentation.components.AppTextOnlyReadField
import vn.finance.profile.presentation.components.AvatarComponent

@Composable
fun ProfileView(modifier: Modifier) {
    val viewModel: ProfileViewModel = hiltViewModel()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val appException by viewModel.appException.collectAsStateWithLifecycle()
    val person by viewModel.person.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (person != null) {
            AvatarComponent(person!!.avatar)
            Box(modifier = Modifier.padding(vertical = 16.dp)) {
                AppTextOnlyReadField(
                    value = person!!.name,
                    label = stringResource(R.string.full_name),
                    placeHolder = stringResource(
                        R.string.your_name
                    )
                )
            }
            AppTextOnlyReadField(
                value = person!!.email,
                label = stringResource(R.string.email),
                placeHolder = stringResource(
                    R.string.your_email
                )
            )
            Box(modifier = Modifier.padding(vertical = 16.dp)) {
                AppTextOnlyReadField(
                    value = person!!.mobileNumber,
                    label = stringResource(R.string.mobile_number),
                    placeHolder = stringResource(
                        R.string.your_mobile_number
                    )
                )
            }
        }

        if (appException != null) {
            AlertExceptionDialogComponent(message = stringResource(R.string.unable_to_fetch_your_profile_information_please_check_your_internet_connection_and_try_again_if_the_issue_persists_contact_support)) {
                viewModel.onDismissAppException()
            }
        }

        if (isLoading) {
            FullScreenLoadingDialogComponent()
        }
    }
}
