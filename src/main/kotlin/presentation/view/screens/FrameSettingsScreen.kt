package presentation.view.screens

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
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
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import models.files.FilePickerFile
import presentation.view.components.filePicker.FilePickerWindow
import presentation.view.components.settingsScreen.*
import presentation.view.themes.mainWallpaperColor
import presentation.view.themes.secondaryColor
import presentation.viewmodels.FilePickerViewModel

class FrameSettingsScreen : Screen {
    @Composable
    override fun Content() {
        val filePickerViewModel: FilePickerViewModel = viewModel()

        Row(
            Modifier
                .fillMaxSize()
                .background(mainWallpaperColor)
        ) {
            FrameOutterContainer(
                Modifier
                    .padding(start = 60.dp, top = 60.dp, bottom = 60.dp)
                    .weight(0.7f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            bottomStart = 20.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
            ) {
                FrameInnerContainer(
                    Modifier
                        .padding(
                            start = 50.dp,
                            top = 0.dp,
                            bottom = 55.dp,
                            end = 50.dp
                        )
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Box(Modifier.fillMaxSize()) {
                        val files = filePickerViewModel.selectedFiles
                        val lazyGridState = rememberLazyGridState()
                        val boxWidth = 132.dp
                        val boxHeight = 150.dp

                        Box(modifier = Modifier.fillMaxSize()) {
                            LazyVerticalGrid(
                                state = lazyGridState,
                                modifier = Modifier
                                    .fillMaxSize().clip(RoundedCornerShape(12.dp))
                                    .background(color = secondaryColor),
                                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 20.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                columns = GridCells.Adaptive(boxWidth),
                            ) {
                                items(files) { file ->
                                    Column(
                                        Modifier.width(boxWidth).height(boxHeight).padding(10.dp)
                                            .clip(RoundedCornerShape(12.dp))
                                    ) {
                                        val data = FilePickerFile(file)
                                        ImageFrame(item = data, boxWidth = boxWidth)
                                    }
                                }
                            }

                            VerticalScrollbar(
                                modifier = Modifier.align(Alignment.CenterEnd)
                                    .fillMaxHeight().padding(5.dp),
                                adapter = rememberScrollbarAdapter(lazyGridState)
                            )
                        }

                        var showFilePicker by remember { mutableStateOf(false) }
                        AddFramesButton(
                            Modifier
                                .align(Alignment.BottomEnd)
                                .padding(end = 35.dp, bottom = 35.dp)
                        ) {
                            showFilePicker = true
                        }

                        if (showFilePicker) FilePickerWindow(filePickerViewModel) { showFilePicker = false }
                    }
                }
            }

            FramesSettings(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, bottom = 60.dp, end = 60.dp)
                    .weight(0.3f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
            )
        }
    }
}
