package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.RestorePage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import presentation.view.themes.mainWallpaperColor
import presentation.view.themes.whiteColor

@Composable
fun FilePickerButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String? = null,
    onClick: (() -> Unit)? = null
) {
    FloatingActionButton(
        onClick = { onClick?.invoke() },
        modifier = modifier,
        shape = CircleShape,
        backgroundColor = mainWallpaperColor, contentColor = whiteColor
    ) {
        Icon(icon, contentDescription)
    }

}

@Composable
@Preview
fun FilePickerButtonPreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
        FilePickerButton(icon = Icons.Default.RestorePage) { }
        FilePickerButton(icon = Icons.AutoMirrored.Filled.ArrowBack) { }
        FilePickerButton(icon = Icons.Filled.Check) { }
    }
}