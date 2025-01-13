package presentation.view.components.settingsScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import models.files.FilePickerFile
import presentation.view.themes.collageLightBlueColor

@Composable
fun ImageFrame(item: FilePickerFile, boxSize: Dp = 256.dp) {
    Column(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(collageLightBlueColor)
            .size(boxSize)
            .padding(horizontal = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        AsyncImage(
            model = item.path,
            contentDescription = item.name,
        )

        Text(
            text = item.name,
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview
@Composable
fun ImageFramePreview() {
    ImageFrame(
        FilePickerFile(
            "Picture", false,
            "/home/kauegaruda/Pictures/342146cf-c687-4506-9482-cc7315f9fec4.jpeg",
        )
    )
}