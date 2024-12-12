package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                modifier = Modifier.padding(horizontal = 25.dp),
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
                thickness = 1.dp,
            )

            val placeholderList = (100..1000).toList()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = secondaryColor)
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(placeholderList) { i ->
                    CollageMediaFilePickerRow(i, rowSpacing)
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