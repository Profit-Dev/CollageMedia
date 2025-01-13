package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import models.files.FilePickerFile
import presentation.view.themes.collageLightBlueColor
import presentation.view.themes.mainWallpaperColor

@Composable
fun CollageMediaFilePickerItem(item: FilePickerFile, isSelected: Boolean, boxSize: Dp = 125.dp) {
    Column(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) mainWallpaperColor else collageLightBlueColor)
            .size(boxSize)
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
            AsyncImage(
                model = item.path,
                contentDescription = item.name,
            )
        }

        Text(
            text = item.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview
@Composable
fun CollageMediaFilePickerRowItem() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(50.dp)) {
        CollageMediaFilePickerItem(FilePickerFile("Directory", true, ""), false)
        CollageMediaFilePickerItem(FilePickerFile("Selected File", false, ""), true)
        CollageMediaFilePickerItem(FilePickerFile("File", false, ""), false)
    }
}
