package vn.finance.profile.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import vn.finance.profile.presentation.R

@Composable
fun AvatarComponent(url: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build(),
        placeholder = painterResource(R.drawable.avatar_default),
        contentDescription = stringResource(R.string.profile_avatar),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        onError = {
            println(it.result.throwable.printStackTrace())
        },
        onSuccess = {
            println(it.result.dataSource.toString())
        },
        onLoading = {
            println("AsyncImage is loading")
        },
        error = painterResource(R.drawable.avatar_default),
        fallback = painterResource(R.drawable.avatar_default),
    )
}