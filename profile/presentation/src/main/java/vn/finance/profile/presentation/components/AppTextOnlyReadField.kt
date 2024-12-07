package vn.finance.profile.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Modifier
import vn.finance.profile.presentation.EMPTY_STRING

@Composable
fun AppTextOnlyReadField(
    value: String = EMPTY_STRING,
    label: String,
    placeHolder: String,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.onSurface)
            )
        },
        onValueChange = { _ -> },
        enabled = false,
        readOnly = true,
        isError = false,
        placeholder = { Text(text = placeHolder) },
        singleLine = true,
        maxLines = 1,
    )
}