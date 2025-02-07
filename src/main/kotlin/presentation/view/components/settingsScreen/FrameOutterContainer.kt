package presentation.view.components.settingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.BoxWithConstraints
import presentation.view.themes.windowColor

@Composable
fun FrameOutterContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    BoxWithConstraints(
        modifier
            .fillMaxSize()
            .background(windowColor)
    ) {
        val scaleFactor = (maxWidth / 1200.dp).coerceAtMost(1f)
        val titleSize = (50 * scaleFactor).coerceAtLeast(20f).sp
        val titlePadding = (50 * scaleFactor).coerceAtLeast(20f).dp

        Column(
            modifier
                .fillMaxSize()
                .background(windowColor)
        ) {
            Text(
                "FRAMES",
                fontSize = titleSize,
                modifier = Modifier.padding(start = titlePadding, top = (20 * scaleFactor).dp, bottom =  (20 * scaleFactor).dp)
            )
            content()
        }
    }
}