package presentation.view.components.settingsScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.components.settingsScreen.settingsConfiguration.OrientationSettingsSwitch
import presentation.view.components.settingsScreen.settingsConfiguration.SettingsContainer
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.secondaryColor
import presentation.view.themes.whiteColor

@Composable
fun FramesSettings(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier
            .fillMaxSize()
            .background(secondaryColor),
    ) {
        val scaleFactor = (maxWidth / 600.dp).coerceAtMost(1f)
        val titleSize = (50 * scaleFactor).coerceAtLeast(24f).sp
        val textSize = (24 * scaleFactor).coerceAtLeast(14f).sp
        val padding = (20 * scaleFactor).coerceAtLeast(10f).dp

        Column(
            Modifier.fillMaxSize()
        ) {
            Text(
                "SETTINGS",
                fontSize = titleSize,
                color = whiteColor,
                modifier = Modifier
                    .padding(top = padding, bottom = padding)
                    .align(Alignment.CenterHorizontally)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(whiteColor)
            )
            SettingsContainer(Modifier.padding(start = padding, top = padding, end = padding)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Orientation",
                        color = secondaryColor,
                        fontSize = textSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = padding)
                    )
                    OrientationSettingsSwitch(modifier = Modifier.padding(end = padding))
                }
            }
        }
    }
}


@Preview
@Composable
fun FrameSettingsView() {
    CollageMediaTheme { FramesSettings() }
}