package presentation.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.themes.windowColor

@Composable
fun FrameOutterContainer(
    modifier: Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier
            .fillMaxSize()
            .background(windowColor)
    ) {
        Text(
            "FRAMES",
            fontSize = 50.sp,
            modifier = Modifier
                .padding(start = 50.dp, top = 20.dp, bottom = 20.dp)
        )
        content()
    }
}
