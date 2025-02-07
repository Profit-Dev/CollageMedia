package data.services

import domain.models.CollageConfiguration
import domain.models.picture.PdfPictureProperties
import domain.models.picture.PictureOrientation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.common.PDRectangle
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject
import org.apache.pdfbox.util.Matrix
import java.io.File
import java.io.IOException
import java.time.LocalDateTime

/**
 * A service class responsible for generating a PDF document from a list of images.
 *
 * @author Kauê Miziara
 */
class PdfService {
    /**
     * Creates a PDF file with the given images arranged according to the provided collage configuration.
     *
     * @param images The list of image files to include in the PDF.
     * @param config The collage configuration specifying layout details.
     * @throws IOException If an error occurs while creating the PDF.
     */
    suspend fun createPdf(images: List<File>, config: CollageConfiguration) = withContext(Dispatchers.IO) {
        val a4Width = PDRectangle.A4.width
        val a4Height = PDRectangle.A4.height

        val (pageWidth, pageHeight) = when (config.pictureOrientation) {
            PictureOrientation.VERTICAL -> Pair(a4Width, a4Height)
            PictureOrientation.HORIZONTAL -> Pair(a4Height, a4Width)
        }

        try {
            PDDocument().apply {
                images.chunked(config.imagesPerPage).forEach { pageImages ->
                    createPage(pageWidth, pageHeight, this, config, pageImages)
                }
                val userDir = System.getProperty("user.dir")
                save("$userDir/${LocalDateTime.now()}.pdf")
                close()
            }
        } catch (e: IOException) {
            throw IOException("An error occurred while creating PDF: ${e.message}")
        }
    }

    /**
     * Creates a single PDF page and arranges images based on the collage configuration.
     *
     * @param pageWidth The width of the PDF page.
     * @param pageHeight The height of the PDF page.
     * @param document The PDF document to which the page will be added.
     * @param config The collage configuration specifying rows and columns.
     * @param images The list of images to be added to this page.
     * @throws IOException If an error occurs while writing to the PDF.
     */
    private suspend fun createPage(
        pageWidth: Float,
        pageHeight: Float,
        document: PDDocument,
        config: CollageConfiguration,
        images: List<File>
    ) = withContext(Dispatchers.IO) {
        var page = PDPage(PDRectangle(pageWidth, pageHeight))
        document.addPage(page)

        PDPageContentStream(document, page).apply {
            transform(Matrix(1f, 0f, 0f, -1f, 0f, pageHeight))

            val columnWidth = pageWidth / config.columns
            val columnHeight = pageHeight / config.rows

            for ((i, im) in images.withIndex()) {
                val picture = PDImageXObject.createFromFile(im.absolutePath.toString(), document)
                val rowIndex = i / config.columns
                val columnIndex = i % config.columns
                if (rowIndex >= config.rows) break

                saveGraphicsState()
                calculatePicturePosition(picture, rowIndex, columnIndex, columnWidth, columnHeight).let {
                    transform(Matrix(1f, 0f, 0f, -1f, it.x, it.y))
                    drawImage(picture, 0f, 0f, it.width, it.height)
                }
                restoreGraphicsState()
            }

            close()
        }
    }

    /**
     * Calculates the position and scaled dimensions of an image inside its designated cell in the collage.
     *
     * @param picture The image to be positioned.
     * @param rowIndex The row index of the image.
     * @param columnIndex The column index of the image.
     * @param columnWidth The width of a single column in the collage.
     * @param columnHeight The height of a single row in the collage.
     * @return A [PdfPictureProperties] object containing the calculated position and dimensions.
     */
    private fun calculatePicturePosition(
        picture: PDImageXObject,
        rowIndex: Int,
        columnIndex: Int,
        columnWidth: Float,
        columnHeight: Float,
    ): PdfPictureProperties {
        val xScale = columnWidth / picture.width
        val yScale = columnHeight / picture.height
        val scale = minOf(xScale, yScale)

        val scaledWidth = picture.width * scale
        val scaledHeight = picture.height * scale

        val cellCenterX = (columnIndex + 0.5f) * columnWidth
        val cellCenterY = (rowIndex + 0.5f) * columnHeight

        val x = cellCenterX - scaledWidth / 2
        val y = cellCenterY + scaledHeight / 2

        return PdfPictureProperties(x, y, scaledWidth, scaledHeight)
    }
}