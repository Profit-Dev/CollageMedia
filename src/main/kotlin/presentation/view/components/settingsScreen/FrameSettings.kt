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
        val textSize = (24 * scaleFactor).coerceIn(14f, 24f).sp
        val padding = (20 * scaleFactor).coerceAtLeast(10f).dp
        val widthButton = (224 * scaleFactor).coerceAtMost(224f).dp
        val heightButton = (42 * scaleFactor).coerceIn(32f, 42f).dp
        val spacerCard = (38 * scaleFactor).coerceAtMost(38f).dp
        val spacerSwitchButton = (100 * scaleFactor).coerceAtMost(100f).dp

        Column(
            Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(padding)
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
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Spacer(modifier = Modifier.width(spacerCard))
                    Text(
                        text = "Orientation",
                        color = secondaryColor,
                        fontSize = textSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = padding)
                    )
                    Spacer(modifier = Modifier.width(spacerSwitchButton))
                    OrientationSettingsSwitch(
                        modifier = modifier
                            .padding(end = padding)
                            .width(widthButton)
                            .height(heightButton)
                    )
                }
            }
            SettingsContainer(Modifier.padding(start = padding, top = padding, end = padding)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Spacer(modifier = Modifier.width(spacerCard))
                    Text(
                        text = "Grid",
                        color = secondaryColor,
                        fontSize = textSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = padding)
                    )
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