package presentation.view.components.settingsScreen.settingsConfiguration

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.themes.mainWallpaperColor
import presentation.view.themes.secondaryColor

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    width: Int = 224,
    height: Int = 42,
    thumbColor: Color = Color.White,
    checkedTrackColor: Color = secondaryColor,
    uncheckedTrackColor: Color = mainWallpaperColor
) {
    BoxWithConstraints()
    {
        val toggleState = remember { mutableStateOf(checked) }
        val scaleFactor = (maxWidth / 224.dp).coerceIn(0f, 1f)
        val buttonsize = (32 * scaleFactor).coerceIn(16f, 32f).dp
        val fontSize = (16 * scaleFactor).coerceIn(10f, 16f).sp

        Box(
            modifier = modifier
                .size(width = width.dp, height = height.dp)
                .clip(RoundedCornerShape(percent = 100))
                .background(if (toggleState.value) checkedTrackColor else uncheckedTrackColor)
                .clickable {
                    toggleState.value = !toggleState.value
                    onCheckedChange(toggleState.value)
                },
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = toggleState.value,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    text = "HORIZONTAL",
                    color = Color.White,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(4.dp)
                )
            }

            AnimatedVisibility(
                visible = !toggleState.value,
                enter = fadeIn(animationSpec = tween(durationMillis = 100)),
                exit = fadeOut(animationSpec = tween(durationMillis = 100))
            ) {
                Text(
                    text = "VERTICAL",
                    color = Color.White,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(4.dp)
                )
            }

            Box(
                modifier = Modifier
                    .size(buttonsize)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(thumbColor)
                    .align(if (toggleState.value) Alignment.CenterEnd else Alignment.CenterStart)
            )
        }
    }
}

@Composable
fun OrientationSettingsSwitch(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(true) }

    CustomSwitch(
        checked = checked,
        onCheckedChange = { checked = it },
        width = 224,
        height = 42,
        thumbColor = Color.White,
        checkedTrackColor = secondaryColor,
        uncheckedTrackColor = mainWallpaperColor,
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewOrientationSwitch() {
    OrientationSettingsSwitch()
}