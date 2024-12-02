package models

/**
 * Data class representing the configurations for a collage.
 *
 * @property pictureOrientation The orientation of the pictures in the collage.
 * @property imagesPerPage The number of images to be displayed per page.
 */
data class CollageConfiguration(
    val pictureOrientation: PictureOrientation,
    val imagesPerPage: Int,
)
