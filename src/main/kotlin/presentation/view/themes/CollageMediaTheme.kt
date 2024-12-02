package presentation.view.themes

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import org.neverland.collage_media.generated.resources.Kodchasan_Regular
import org.neverland.collage_media.generated .resources.Res

@Composable
fun CollageMediaTheme(
    content: @Composable () -> Unit
) {
    val kodchasan = FontFamily(
        Font(resource = Res.font.Kodchasan_Regular, FontWeight.Normal)
    )

    val appTypography = Typography(
        h1 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 101.sp
        ),
        h2 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 63.sp
        ),
        h3 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 50.sp
        ),
        h4 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 36.sp
        ),
        h5 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 25.sp
        ),
        h6 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 21.sp
        ),
        body1 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp
        ),
        body2 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ),
        subtitle1 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp
        ),
        subtitle2 = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ),
        button = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        ),
        overline = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        ),
        caption = TextStyle(
            fontFamily = kodchasan,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )
    )
    val lightTheme = lightColors(
        primary = mainWallpaperColor,
        secondary = secondaryColor
    )


    MaterialTheme(
        colors = lightTheme,
        typography = appTypography,
        content = content
    )
}