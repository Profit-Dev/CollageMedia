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
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.secondaryColor
import presentation.view.themes.windowColor

@Composable
fun FilePickerWindow() {
    CollageMediaTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(color = windowColor),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Column(
                modifier = Modifier.padding(start = 50.dp, top = 30.dp)
            ) {
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

            Divider(
                color = secondaryColor,
                thickness = 2.dp,
            )

            CollageMediaFilePicker(
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 20.dp)
            )
        }
    }
}

@Preview
@Composable
fun FilePickerWindowPreview() {
    FilePickerWindow()
}
