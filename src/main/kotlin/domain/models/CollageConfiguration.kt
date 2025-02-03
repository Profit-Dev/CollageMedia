package domain.models

import domain.exceptions.collageConfiguration.CollageConfigurationNegativeRowsOrColumnsException
import domain.exceptions.collageConfiguration.CollageConfigurationZeroRowsOrColumnsException
import domain.models.picture.PictureOrientation

/**
 * Data class representing the configurations for a collage.
 *
 * @property pictureOrientation The orientation of the pictures in the collage.
 * @property rows The number of picture rows to be displayed displayed per page.
 * @property columns The number of picture columns to be displayed displayed per page.
 * @property imagesPerPage The number of images to be displayed per page.
 *
 * @throws CollageConfigurationZeroRowsOrColumnsException If `rows` or `columns` is set to zero.
 * @throws CollageConfigurationNegativeRowsOrColumnsException If `rows` or `columns` is negative.
 *
 * @author Kauê Miziara
 */
data class CollageConfiguration(
    val pictureOrientation: PictureOrientation,
    val rows: Int,
    val columns: Int,
) {
    val imagesPerPage: Int

    init {
        if (rows == 0 || columns == 0) {
            throw CollageConfigurationZeroRowsOrColumnsException(
                message = "Zero rows or columns passed for configuration.",
            )
        }

        if (rows < 0 || columns < 0) {
            throw CollageConfigurationNegativeRowsOrColumnsException(
                message = "Negative rows or columns passed for configuration.",
            )
        }

        imagesPerPage = rows * columns
    }
}
