package presentation.view.components.settingsScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.view.themes.mainWallpaperColor

@Composable
fun AddFramesButton(modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    FloatingActionButton(
        onClick = { onClick?.invoke() },
        modifier = modifier,
        shape = CircleShape,
        backgroundColor = mainWallpaperColor,
        contentColor = Color.White
    ) {
        Icon(Icons.Filled.Add, "+", modifier = Modifier.size(100.dp))
    }
}

@Preview
@Composable
fun ViewButton() {
    AddFramesButton { }
}