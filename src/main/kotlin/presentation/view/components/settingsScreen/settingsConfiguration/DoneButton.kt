package presentation.view.components.settingsScreen.settingsConfiguration

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.themes.mainWallpaperColor
import presentation.view.themes.whiteColor


@Composable
fun DoneButton(
    modifier: Modifier = Modifier,
    width: Int = 540,
    height: Int = 70,
    onClick: (() -> Unit)? = null
) {
    BoxWithConstraints()
    {
        val scaleFactor = (maxWidth / 540.dp).coerceIn(0f, 1f)
        val fontSize = (32 * scaleFactor).coerceIn(24f, 32f).sp
        Button(
            onClick = { onClick?.invoke() },
            modifier = modifier
                .width(width.dp)
                .height(height.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = mainWallpaperColor, contentColor = whiteColor)

        ) {
            Text("Done", fontSize = fontSize)
        }
    }
}

@Preview
@Composable
fun DoneButtonPreview() {
    DoneButton { }
}