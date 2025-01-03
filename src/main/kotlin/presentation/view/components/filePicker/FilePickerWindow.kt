package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.secondaryColor
import presentation.view.themes.windowColor
import presentation.viewmodels.FilePickerViewModel

@Composable
fun FilePickerWindow(
    filePickerViewModel: FilePickerViewModel,
    onCloseRequest: () -> Unit,
) {
    CollageMediaTheme {
        Window(
            title = "File Picker",
            onCloseRequest = onCloseRequest
        ) {
            Column(
                modifier = Modifier.fillMaxSize().background(color = windowColor),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, top = 30.dp, bottom = 30.dp, end = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "FILE PICKER",
                            color = secondaryColor,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            text = "Select your images",
                            color = secondaryColor,
                            fontSize = 10.sp,
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                        FilePickerReturnButton(modifier = Modifier.size(50.dp)) {
                            filePickerViewModel.currentDirectory.value.parentFile?.let {
                                filePickerViewModel.updateCurrentDirectory(it)
                            }
                        }
                        FilePickerCheckButton(Modifier.size(50.dp)) {
                            onCloseRequest()
                        }
                    }

                }

                Divider(
                    color = secondaryColor,
                    thickness = 1.dp,
                )

                CollageMediaFilePicker(
                    modifier = Modifier.padding(horizontal = 50.dp, vertical = 20.dp),
                    filePickerViewModel = filePickerViewModel,
                )
            }
        }
    }
}

@Preview
@Composable
fun FilePickerWindowPreview() {
    val viewModel = FilePickerViewModel()
    FilePickerWindow(viewModel) {}
}
