package presentation.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.themes.secondaryColor
import presentation.view.themes.whiteColor

@Composable
fun FramesSettings(modifier: Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(secondaryColor),
    ) {
        Text(
            "SETTINGS",
            fontSize = 50.sp,
            color = whiteColor,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(whiteColor)
        )
    }
}

