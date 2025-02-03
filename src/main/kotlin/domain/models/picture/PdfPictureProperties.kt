package domain.models.picture

/**
 * Represents the properties of an image in a PDF, including its position and scaled dimensions.
 *
 * @property x The X-coordinate for positioning the image.
 * @property y The Y-coordinate for positioning the image.
 * @property width The scaled width of the image.
 * @property height The scaled height of the image.
 *
 * @author Kauê Miziara
 */
data class PdfPictureProperties(
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float
)
