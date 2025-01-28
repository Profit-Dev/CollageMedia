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
    Column(
        modifier
            .fillMaxSize()
            .background(secondaryColor),
    ) {
        Text(
            "SETTINGS",
            fontSize = 50.sp,
            color = whiteColor,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(whiteColor)
        )
        SettingsContainer(Modifier.padding(start = 30.dp, top = 30.dp, end = 30.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Orientation",
                    color = secondaryColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 30.dp)
                )
                OrientationSettingsSwitch(modifier = Modifier.padding(end = 30.dp))
            }
        }

    }
}

@Preview
@Composable
fun FrameSettingsView() {
    CollageMediaTheme { FramesSettings() }
}