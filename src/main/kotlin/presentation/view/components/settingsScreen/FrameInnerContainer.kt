package presentation.view.components.settingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.view.themes.secondaryColor

@Composable
fun FrameInnerContainer(
    modifier: Modifier,
    content: @Composable () -> Unit = {}
) {
    BoxWithConstraints() {
        val scaleFactor = (maxWidth / 1100.dp).coerceAtMost(1f)
        val padding = (20 * scaleFactor).coerceAtLeast(10f).dp

        Column(
            modifier
                .fillMaxSize()
                .background(secondaryColor)
                .padding(padding)
        ) {
            content()
        }
    }
}