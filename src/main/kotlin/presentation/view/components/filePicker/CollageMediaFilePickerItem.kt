package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import models.files.FilePickerFile
import presentation.view.themes.collageLightBlueColor

@Composable
fun CollageMediaFilePickerItem(item: FilePickerFile) {
    Column(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(collageLightBlueColor)
            .size(125.dp)
            .padding(horizontal = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        if (item.isDir) {
            Icon(
                imageVector = Icons.Default.Folder,
                "Directory",
                modifier = Modifier.weight(1f),
            )
        } else {
            Icon(
                imageVector = Icons.Default.Image,
                "File",
                modifier = Modifier.weight(1f),
            )
        }

        Text(
            text = item.name,
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview
@Composable
fun CollageMediaFilePickerRowItem() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(50.dp)) {
        CollageMediaFilePickerItem(FilePickerFile("Directory", true))
        CollageMediaFilePickerItem(FilePickerFile("File", false))
    }
}
