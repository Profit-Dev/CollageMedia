package presentation.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import presentation.view.components.FrameOutterContainer
import presentation.view.components.FramesSettings
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import presentation.view.components.FrameInnerContainer
import presentation.view.themes.mainWallpaperColor

class FrameSettingsScreen : Screen {
    @Composable
    override fun Content() {
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
                )
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
