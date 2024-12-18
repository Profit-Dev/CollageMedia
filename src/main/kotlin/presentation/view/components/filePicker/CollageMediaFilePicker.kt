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
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import extensions.filterDirectoriesAndPictures
import models.files.FilePickerFile
import presentation.view.themes.CollageMediaTheme
import presentation.view.themes.secondaryColor
import java.io.File

@Composable
fun CollageMediaFilePicker(
    modifier: Modifier = Modifier,
    selectedFiles: SnapshotStateList<File>,
) {
    CollageMediaTheme {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            var currentDirectory by remember { mutableStateOf(File(System.getProperty("user.home"))) }
            var files by remember {
                mutableStateOf(currentDirectory.listFiles()?.filterDirectoriesAndPictures() ?: emptyList())
            }

            val lazyGridState = rememberLazyGridState()

            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$currentDirectory",
                    color = secondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "${selectedFiles.size} items selected",
                    color = secondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            val boxSize = 128.dp
            Box(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    state = lazyGridState,
                    modifier = Modifier
                        .fillMaxSize().clip(RoundedCornerShape(12.dp))
                        .background(color = secondaryColor),
                    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    columns = GridCells.Adaptive(boxSize),
                ) {
                    items(files) { file ->
                        var isSelected by remember { mutableStateOf(file in selectedFiles) }
                        Column(
                            Modifier.size(boxSize).padding(10.dp)
                                .clip(RoundedCornerShape(12.dp)).clickable {
                                    when {
                                        file.isDirectory -> {
                                            currentDirectory = file
                                            files = file.listFiles()?.filterDirectoriesAndPictures() ?: emptyList()
                                        }

                                        else -> {
                                            if (file !in selectedFiles) selectedFiles.add(file)
                                            else selectedFiles.remove(file)

                                            isSelected = !isSelected
                                        }
                                    }
                                }) {
                            val data = FilePickerFile(file)
                            CollageMediaFilePickerItem(item = data, isSelected = isSelected, boxSize = boxSize)
                        }
                    }
                }

                VerticalScrollbar(
                    modifier = Modifier.align(Alignment.CenterEnd)
                        .fillMaxHeight().padding(5.dp),
                    adapter = rememberScrollbarAdapter(lazyGridState)
                )
            }
        }
    }
}

@Preview
@Composable
fun CollageMediaFilePickerPreview() {
    val selectedFiles = listOf(File("/"))
    CollageMediaFilePicker(selectedFiles = selectedFiles.toMutableStateList())
}