package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.secondaryColor

@Composable
fun CollageMediaFilePicker(modifier: Modifier = Modifier) {
    CollageMediaTheme {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            val rowSpacing: Dp = 185.dp

            Row(
                horizontalArrangement = Arrangement.spacedBy(rowSpacing)
            ) {
                Text(
                    text = "NAME",
                    color = secondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "SIZE",
                    color = secondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Divider(
                color = secondaryColor,
                thickness = 2.dp,
            )

            val placeholderList = (1..100).toList()
            LazyColumn(
                modifier = Modifier.fillMaxSize().background(color = Color.White)
            ) {
                items(placeholderList) { i ->
                    Row { Text("$i") }
                }
            }
        }
    }
}

@Preview
@Composable
fun CollageMediaFilePickerPreview() {
    CollageMediaFilePicker()
}