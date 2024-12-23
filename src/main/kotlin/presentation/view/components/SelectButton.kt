package presentation.view.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.view.themes.secondaryColor
import presentation.view.themes.whiteColor


@Composable
fun SelectButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(110.dp)
            .width(600.dp),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = secondaryColor)

    ) {
        Text(text = "Select your frames", fontSize = 40.sp, color = whiteColor, fontWeight = FontWeight.Normal)
    }
}

@Composable
@Preview
fun SelectButtonPreview() {
    SelectButton { }
}