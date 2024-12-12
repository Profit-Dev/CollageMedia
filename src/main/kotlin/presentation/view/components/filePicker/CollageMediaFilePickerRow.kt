package presentation.view.components.filePicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.view.themes.collageLightBlueColor

@Composable
fun CollageMediaFilePickerRow(item: Int) {
    Box(
        Modifier
            .background(collageLightBlueColor)
            .padding(20.dp)
            .height(50.dp)
            .fillMaxWidth(),
    ) {
        Text("$item")
    }
}
