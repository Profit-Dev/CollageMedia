package presentation.view.components.settingsScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.components.settingsScreen.settingsConfiguration.*
import presentation.view.themes.*

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
        val textSizeRowColumn = (24 * scaleFactor).coerceIn(22f, 24f).sp
        val padding = (20 * scaleFactor).coerceAtLeast(10f).dp
        val widthOrientationSwitchButton = (224 * scaleFactor).coerceAtMost(224f).dp
        val heightOrientationSwitchButton = (42 * scaleFactor).coerceIn(32f, 42f).dp
        val spacerOrientationSwitchButton = (80 * scaleFactor).coerceAtMost(100f).dp
        val spacerGridRowsColumns = (179 * scaleFactor).coerceAtMost(179f).dp
        val spacerRowsXColumns = (16 * scaleFactor).coerceAtMost(26f).dp

        Column(
            Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                "SETTINGS",
                fontSize = titleSize,
                color = whiteColor,
                modifier = Modifier
                    .padding(start = padding, top = padding, bottom = padding, end = padding)
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
                    Spacer(modifier = Modifier.width(padding))
                    Text(
                        text = "Orientation",
                        color = secondaryColor,
                        fontSize = textSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = padding)
                    )
                    Spacer(modifier = Modifier.width(spacerOrientationSwitchButton))
                    OrientationSettingsSwitch(
                        modifier = modifier
                            .padding(end = padding)
                            .width(widthOrientationSwitchButton)
                            .height(heightOrientationSwitchButton)
                    )
                }
            }
            SettingsContainer(Modifier.padding(start = padding, top = padding, end = padding)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Spacer(modifier = Modifier.width(padding))
                    Text(
                        text = "Grid",
                        color = secondaryColor,
                        fontSize = textSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = padding)
                    )
                    Spacer(modifier = Modifier.width(spacerGridRowsColumns))
                    Box(
                        modifier = Modifier
                            .size(90.dp * scaleFactor, 50.dp * scaleFactor)
                            .border(1.dp, color = (secondaryColor), shape = RoundedCornerShape(1.dp))
                            .background(collageLightBlueColor),
                        contentAlignment = Alignment.Center
                    ) {
                        var text by remember { mutableStateOf("") }
                        BasicTextField(
                            value = text,
                            onValueChange = { text = it },
                            singleLine = true,
                            textStyle = TextStyle(
                                color = secondaryColor,
                                fontSize = textSizeRowColumn * scaleFactor,
                                fontWeight = FontWeight.Medium,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (text.isEmpty()) {
                                        Text(
                                            text = "Row",
                                            color = secondaryColor.copy(alpha = 0.5f),
                                            fontSize = textSizeRowColumn * scaleFactor,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                        )
                                    }
                                    innerTextField()
                                }
                            }

                        )
                    }
                    Spacer(modifier = Modifier.width(spacerRowsXColumns))
                    Text(
                        text = "x",
                        color = secondaryColor,
                        fontSize = textSize
                    )
                    Spacer(modifier = Modifier.width(spacerRowsXColumns))
                    Box(
                        modifier = Modifier
                            .size(90.dp * scaleFactor, 50.dp * scaleFactor)
                            .border(1.dp, color = (secondaryColor), shape = RoundedCornerShape(1.dp))
                            .background(collageLightBlueColor),
                        contentAlignment = Alignment.Center
                    ) {
                        var text by remember { mutableStateOf("") }
                        BasicTextField(
                            value = text,
                            onValueChange = { text = it },
                            singleLine = true,
                            textStyle = TextStyle(
                                color = secondaryColor,
                                fontSize = textSizeRowColumn * scaleFactor,
                                fontWeight = FontWeight.Medium,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (text.isEmpty()) {
                                        Text(
                                            text = "Column",
                                            color = secondaryColor.copy(alpha = 0.5f),
                                            fontSize = textSizeRowColumn * scaleFactor,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            DoneButton (modifier = Modifier.padding(start = padding, bottom = padding, end= padding)){ }
        }
    }
}

@Preview
@Composable
fun FrameSettingsView() {
    CollageMediaTheme { FramesSettings() }
}