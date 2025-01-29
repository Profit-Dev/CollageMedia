package presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import domain.exceptions.collageConfiguration.CollageConfigurationNegativeRowsOrColumnsException
import domain.exceptions.collageConfiguration.CollageConfigurationZeroRowsOrColumnsException
import domain.models.CollageConfiguration
import domain.models.PictureOrientation

class SettingsViewModel : ViewModel() {
    var errorMessage = mutableStateOf<String?>(null)
        private set

    private var collageConfiguration: CollageConfiguration? = null

    fun setupConfiguration(
        orientation: PictureOrientation,
        rows: Int,
        columns: Int,
    ) = try {
        collageConfiguration = CollageConfiguration(orientation, rows, columns)
        errorMessage.value = null
    } catch (e: CollageConfigurationZeroRowsOrColumnsException) {
        errorMessage.value = "Cannot have zero rows or columns."
    } catch (e: CollageConfigurationNegativeRowsOrColumnsException) {
        errorMessage.value = "Cannot have negative rows or columns."
    } catch (e: Exception) {
        errorMessage.value = "Unexpected error."
    }
}