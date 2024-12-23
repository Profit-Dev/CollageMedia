package presentation.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.components.SelectButton
import presentation.view.themes.mainWallpaperColor
import presentation.view.themes.whiteColor

@Composable
fun MainScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = mainWallpaperColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))

        Text("COLLAGE MEDIA", fontSize = 100.sp, color = whiteColor)
        Spacer(Modifier.height(31.dp))
        SelectButton { }
        Spacer(Modifier.height(31.dp))
        Text("or drop here", fontSize = 20.sp, color = whiteColor)

        Spacer(Modifier.weight(1f))

        Text(
            "Made by Neverland Projects",
            fontSize = 20.sp,
            color = whiteColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 35.dp, bottom = 35.dp)
        )
    }
}

