package models.files

import java.io.File

/**
 * Represents a file shown in a file picker.
 *
 * @property name The name of the file.
 * @property isDir Boolean indicating whether the file is a directory.
 */
data class FilePickerFile(
    val name: String,
    val isDir: Boolean,
) {
    /**
     * Creates a `FilePickerFile` from a `File` object.
     *
     * @param file the `File` object to create the `FilePickerFile` from.
     */
    constructor(file: File) : this(name = file.name, isDir = file.isDirectory)
}