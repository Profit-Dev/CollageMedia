package presentation.view.components.filePicker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
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
            var currentDirectory by remember { mutableStateOf(File(System.getProperty("user.home"))) }
            var files by remember { mutableStateOf(currentDirectory.listFiles()?.toList() ?: emptyList()) }

            val lazyGridState = rememberLazyGridState()

            Box(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    state = lazyGridState,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = secondaryColor)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    columns = GridCells.Adaptive(minSize = 128.dp),
                ) {
                    val boxSize = 125.dp
                    items(files) { file ->
                        Column(Modifier.size(boxSize).clickable {
                            if (file.isDirectory) {
                                currentDirectory = file
                                files = file.listFiles()?.toList() ?: emptyList()
                            } else {
                                onFileSelected?.let { it(file) }
                            }
                        }) {
                            val data = FilePickerFile(file)
                            CollageMediaFilePickerItem(item = data, boxSize = boxSize)
                        }
                    }
                }
                VerticalScrollbar(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .fillMaxHeight()
                        .padding(5.dp),
                    adapter = rememberScrollbarAdapter(lazyGridState)
                )
            }
        }
    }
}

@Preview
@Composable
fun CollageMediaFilePickerPreview() {
    CollageMediaFilePicker()
}