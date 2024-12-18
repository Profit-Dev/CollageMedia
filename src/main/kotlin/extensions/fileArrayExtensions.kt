package extensions

import java.io.File
import java.util.*

fun Array<File>?.filterDirectoriesAndPictures(): List<File>? = this?.filter { f ->
    f.isDirectory or (f.isFile && f.extension.lowercase(Locale.getDefault()) in arrayOf(
        "png", "jpg", "jpeg", "heic"
    ))
}?.toList()
