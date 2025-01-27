package models

/**
 * Data class representing the configurations for a collage.
 *
 * @property pictureOrientation The orientation of the pictures in the collage.
 * @property rows The number of picture rows to be displayed displayed per page.
 * @property columns The number of picture columns to be displayed displayed per page.
 * @property imagesPerPage The number of images to be displayed per page.
 *
 * @author Kauê Miziara
 */
data class CollageConfiguration(
    val pictureOrientation: PictureOrientation,
    val rows: Int,
    val columns: Int,
    val imagesPerPage: Int = rows * columns,
)