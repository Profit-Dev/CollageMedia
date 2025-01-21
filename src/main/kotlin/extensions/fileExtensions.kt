package extensions

import java.io.File
import java.util.*

fun Array<File>?.filterDirectoriesAndPictures(): List<File>? = this?.filter { f ->
    f.isDirectory or (f.isFile && f.extension.lowercase(Locale.getDefault()) in arrayOf(
        "png", "jpg", "jpeg"
    ))
}?.toList()?.sortedWith(compareBy({ !it.isDirectory }, { it.name }))

fun File.listFilesInDirectory(): List<File> = try {
    this.listFiles()?.filterDirectoriesAndPictures() ?: emptyList()
} catch (e: Exception) {
    throw e
}
