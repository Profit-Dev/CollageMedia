package presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import services.FileService
import java.io.File

class FilePickerViewModel(private val fileService: FileService = FileService()) : ViewModel() {
    var currentDirectory = mutableStateOf(File(System.getProperty("user.home")))
        private set

    var directoryFiles = mutableStateOf(fileService.listFiles(currentDirectory.value))
        private set

    val selectedFiles = mutableStateListOf<File>()

    fun updateCurrentDirectory(newDirectory: File) {
        currentDirectory.value = newDirectory
        directoryFiles.value = fileService.listFiles(newDirectory)
    }

    fun toggleFileSelection(file: File) =
        if (file in selectedFiles) selectedFiles.remove(file)
        else selectedFiles.add(file)

    fun toggleSelectedFiles(files: List<File>) = selectedFiles.addAll(
        files.filterNot { it.isDirectory; selectedFiles.contains(it) }
    )

    fun clearFiles() = selectedFiles.clear()
}