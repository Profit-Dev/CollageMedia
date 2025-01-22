package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.RestorePage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.view.themes.mainWallpaperColor
import presentation.view.themes.whiteColor

@Composable
fun FilePickerResetButton(modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    FloatingActionButton(
        onClick = { onClick?.invoke() },
        modifier = modifier,
        shape = CircleShape,
        backgroundColor = mainWallpaperColor, contentColor = whiteColor
    ) {
        Icon(Icons.Outlined.RestorePage, "Restore")
    }
}

@Composable
@Preview
fun FilePickerResetButtonPreview() {
    FilePickerResetButton { }
}