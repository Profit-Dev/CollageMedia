package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.files.FilePickerFile
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.secondaryColor
import java.io.File

@Composable
fun CollageMediaFilePicker(
    modifier: Modifier = Modifier,
    onFileSelected: ((File) -> Unit)? = null,
) {
    CollageMediaTheme {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 25.dp),
            ) {
                Text(
                    text = "NAME",
                    color = secondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                )
            }

            Divider(
                color = secondaryColor,
                thickness = 1.dp,
            )

            var currentDirectory by remember { mutableStateOf(File(System.getProperty("user.home"))) }
            var files by remember { mutableStateOf(currentDirectory.listFiles()?.toList() ?: emptyList()) }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = secondaryColor)
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(files) { file ->
                    Row(Modifier.fillMaxWidth().clickable {
                        if (file.isDirectory) {
                            currentDirectory = file
                            files = file.listFiles()?.toList() ?: emptyList()
                        } else {
                            onFileSelected?.let { it(file) }
                        }
                    }) {
                        val data = FilePickerFile(file)
                        CollageMediaFilePickerRow(item = data)
                    }
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