package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.view.themes.mainWallpaperColor
import presentation.view.themes.whiteColor

@Composable
fun FilePickerReturnkButton(modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Button(
        onClick = { onClick?.invoke() },
        modifier = modifier
            .height(80.dp)
            .width(80.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = mainWallpaperColor, contentColor = whiteColor)
    ) {
        Icon(Icons.Filled.ArrowBackIosNew, "nav-before", modifier = Modifier.size(100.dp))
    }
}

@Composable
@Preview
fun ViewButton2() {
    FilePickerReturnkButton { }
}