package presentation.view.components.settingsScreen.settingsConfiguration

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.collageLightBlueColor

@Composable
fun SettingsContainer(modifier: Modifier = Modifier,content: @Composable () -> Unit = {}) {
    Card(
        backgroundColor = collageLightBlueColor,
        modifier = modifier
            .size(width = 540.dp, height = 122.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        content()
    }
}

@Preview
@Composable
fun SettingsContainerView() {
    CollageMediaTheme { SettingsContainer() }
}