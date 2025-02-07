package presentation.view.components.settingsScreen.settingsConfiguration

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.collageLightBlueColor

@Composable
fun SettingsContainer(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
    BoxWithConstraints {
        val scaleFactorHeight = (maxHeight / 122.dp).coerceAtMost(1f)
        val scaleFactorWidth = (maxWidth / 540.dp).coerceAtMost(1f)
        Card(
            backgroundColor = collageLightBlueColor,
            modifier = modifier
                .width(540.dp * scaleFactorHeight)
                .height(122.dp * scaleFactorWidth)
                .clip(RoundedCornerShape(20.dp))
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun SettingsContainerView() {
    CollageMediaTheme { SettingsContainer() }
}