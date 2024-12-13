package presentation.view.components.settingsScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.view.themes.secondaryColor

@Composable
fun AddFramesButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = Modifier
            .height(80.dp)
            .width(80.dp),
        shape = CircleShape,
        backgroundColor = secondaryColor,
        contentColor = Color.White
    ) {
        Icon(Icons.Filled.Add, "+", modifier = Modifier.size(100.dp))
    }
}

@Preview
@Composable
fun ViewButton() {
    AddFramesButton { }
}