package presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import extensions.listFilesInDirectory
import java.io.File

class FilePickerViewModel : ViewModel() {
    var currentDirectory = mutableStateOf(File(System.getProperty("user.home")))
        private set

    var directoryFiles = mutableStateOf(currentDirectory.value.listFilesInDirectory())
        private set

    val selectedFiles = mutableStateListOf<File>()

    fun updateCurrentDirectory(newDirectory: File) {
        currentDirectory.value = newDirectory
        directoryFiles.value = newDirectory.listFilesInDirectory()
    }

    fun toggleFileSelection(file: File) =
        if (file in selectedFiles) selectedFiles.remove(file)
        else selectedFiles.add(file)

    fun toggleSelectedFiles(files: List<File>) = selectedFiles.addAll(
        files.filterNot { it.isDirectory; selectedFiles.contains(it) }
    )
}