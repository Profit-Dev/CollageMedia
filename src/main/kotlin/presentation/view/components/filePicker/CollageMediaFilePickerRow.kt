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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import models.files.FilePickerFile
import presentation.view.themes.collageLightBlueColor

@Composable
fun CollageMediaFilePickerRow(item: FilePickerFile) {
    Row(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(collageLightBlueColor)
            .fillMaxWidth().height(50.dp)
            .padding(horizontal = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = item.name,
            modifier = Modifier.weight(1f),
        )

        Text(
            text = "${item.size} B",
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview
@Composable
fun CollageMediaFilePickerRowPreview() {
    CollageMediaFilePickerRow(item = FilePickerFile("File name", 8))
}
