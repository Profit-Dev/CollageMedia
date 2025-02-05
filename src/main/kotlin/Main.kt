import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import presentation.view.screens.MainScreen
import presentation.view.themes.CollageMediaTheme
import java.awt.Dimension

@Composable
@Preview
fun App() {
    CollageMediaTheme {
        Navigator(MainScreen())
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        window.minimumSize = Dimension(985,600)
        App()
    }
}
