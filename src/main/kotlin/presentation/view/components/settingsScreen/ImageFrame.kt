package presentation.view.components.settingsScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import models.files.FilePickerFile
import presentation.view.themes.collageLightBlueColor

@Composable
fun ImageFrame(
    item: FilePickerFile, boxWidth: Dp = 128.dp, boxHeight: Dp = 150.dp
) {
    Column(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(collageLightBlueColor)
            .width(boxWidth)
            .height(boxHeight)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        AsyncImage(
            model = item.path,
            contentDescription = item.name,
            alignment = Alignment.Center,
            modifier = Modifier.padding(vertical = 10.dp).height(60.dp)
        )

        Text(
            text = item.name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 15.sp,
        )
    }
}

@Preview
@Composable
fun ImageFramePreview() {
    ImageFrame(
        FilePickerFile(
            "Picture with a very long name text", false,
            "/path"
        )
    )
}