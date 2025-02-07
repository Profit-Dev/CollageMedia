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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import domain.models.picture.PictureOrientation
import presentation.view.components.settingsScreen.settingsConfiguration.*
import presentation.view.themes.*
import presentation.viewmodels.FilePickerViewModel
import presentation.viewmodels.SettingsViewModel

@Composable
fun FramesSettings(
    modifier: Modifier = Modifier,
    filePickerViewModel: FilePickerViewModel = viewModel(),
    settingsViewModel: SettingsViewModel = viewModel(),
) {
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

        var checked = remember { mutableStateOf(true) }
        var rowsText by remember { mutableStateOf("") }
        var columnsText by remember { mutableStateOf("") }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
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
                        checked = checked,
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
                        BasicTextField(
                            value = rowsText,
                            onValueChange = { rowsText = it },
                            singleLine = true,
                            textStyle = TextStyle(
                                color = secondaryColor,
                                fontSize = textSizeRowColumn * scaleFactor,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center
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
                                    if (rowsText.isEmpty()) {
                                        Text(
                                            text = "Row",
                                            color = secondaryColor.copy(alpha = 0.5f),
                                            fontSize = textSizeRowColumn * scaleFactor,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    innerTextField()
                                }
                            }

                        )
                    }

                    RowsXColumnsSpacer(scaleFactor, textSize)

                    Box(
                        modifier = Modifier
                            .size(90.dp * scaleFactor, 50.dp * scaleFactor)
                            .border(1.dp, color = (secondaryColor), shape = RoundedCornerShape(1.dp))
                            .background(collageLightBlueColor),
                        contentAlignment = Alignment.Center
                    ) {
                        BasicTextField(
                            value = columnsText,
                            onValueChange = { columnsText = it },
                            singleLine = true,
                            textStyle = TextStyle(
                                color = secondaryColor,
                                fontSize = textSizeRowColumn * scaleFactor,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center
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
                                    if (columnsText.isEmpty()) {
                                        Text(
                                            text = "Column",
                                            color = secondaryColor.copy(alpha = 0.5f),
                                            fontSize = textSizeRowColumn * scaleFactor,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Center
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
            DoneButton(modifier = Modifier.padding(start = padding, bottom = padding, end = padding)) {
                val orientation = when (checked.value) {
                    false -> PictureOrientation.VERTICAL
                    true -> PictureOrientation.HORIZONTAL
                }

                onClick(
                    orientation = orientation,
                    rows = rowsText.toInt(),
                    columns = columnsText.toInt(),
                    filePickerViewModel = filePickerViewModel,
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}

private fun onClick(
    orientation: PictureOrientation,
    rows: Int,
    columns: Int,
    filePickerViewModel: FilePickerViewModel,
    settingsViewModel: SettingsViewModel,
) {
    try {
        settingsViewModel.setupConfiguration(orientation, rows, columns)
    } catch (e: Exception) {
        throw e
    }

    settingsViewModel.createPdf(filePickerViewModel.selectedFiles)
}

@Composable
private fun RowsXColumnsSpacer(scaleFactor: Float, textSize: TextUnit) {
    val spacerRowsXColumns = (16 * scaleFactor).coerceAtMost(26f).dp

    Spacer(modifier = Modifier.width(spacerRowsXColumns))
    Text(
        text = "x",
        color = secondaryColor,
        fontSize = textSize
    )
    Spacer(modifier = Modifier.width(spacerRowsXColumns))
}

@Preview
@Composable
fun FrameSettingsView() {
    CollageMediaTheme { FramesSettings() }
}