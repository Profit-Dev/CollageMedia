package services

import java.io.File
import java.util.*

/**
 * A service class for handling file operations, such as listing and filtering files within a directory.
 */
class FileService {
    /**
     * Lists all valid files in a given directory.
     * Valid files include directories and image files with extensions "png", "jpg", or "jpeg".
     *
     * @param directory The directory to scan for files.
     * @return A sorted list of valid files and directories, where directories appear before files.
     *         Returns an empty list if the directory contains no valid files or is empty.
     * @throws Exception If an error occurs while accessing the directory.
     */
    fun listFiles(directory: File): List<File> = try {
        filterDirectoriesAndPictures(directory.listFiles()) ?: emptyList()
    } catch (e: Exception) {
        throw e
    }

    /**
     * Filters the given array of files, returning only directories and supported image files.
     * Supported image extensions are "png", "jpg", and "jpeg" (case-insensitive).
     *
     * @param files The array of files to filter.
     * @return A sorted list of valid files or null if the input array is null.
     *         Directories are sorted to appear before files, and items are sorted alphabetically by name.
     */
    private fun filterDirectoriesAndPictures(files: Array<File>?): List<File>? = files?.filter { f ->
        f.isDirectory or (f.isFile && f.extension.lowercase(Locale.getDefault()) in arrayOf(
            "png", "jpg", "jpeg"
        ))
    }?.toList()?.sortedWith(compareBy({ !it.isDirectory }, { it.name }))
}