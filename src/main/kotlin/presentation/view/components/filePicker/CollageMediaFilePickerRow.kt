package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import presentation.view.themes.collageLightBlueColor

@Composable
fun CollageMediaFilePickerRow(item: Int, rowSpacing: Dp) {
    Row(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(collageLightBlueColor)
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 25.dp)
        ,
        horizontalArrangement = Arrangement.spacedBy(rowSpacing),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("$item")
        Text("$item")
    }
}

@Preview
@Composable
fun CollageMediaFilePickerRowPreview() {
    CollageMediaFilePickerRow(5, 185.dp)
}
