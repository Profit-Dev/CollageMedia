package presentation.view.components.settingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.view.themes.secondaryColor

@Composable
fun FrameInnerContainer(
    modifier: Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier
            .fillMaxSize()
            .background(secondaryColor)
    ) {
        content()
    }
}