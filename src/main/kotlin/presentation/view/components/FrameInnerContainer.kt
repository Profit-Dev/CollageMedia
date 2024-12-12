package presentation.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.view.themes.secondaryColor

@Composable
fun FrameInnerContainer(modifier: Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(secondaryColor)
    ) {

    }
}