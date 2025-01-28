package models

import exceptions.collageConfiguration.CollageConfigurationNegativeRowsOrColumnsException
import exceptions.collageConfiguration.CollageConfigurationZeroRowsOrColumnsException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CollageConfigurationTest {
    @Test
    fun positiveRowsAndColumnsShouldsCalculateImagesPerPageCorrectly() {
        val rows = 5
        val columns = 6
        val expected = 30

        val testConfig = CollageConfiguration(PictureOrientation.VERTICAL, rows, columns)

        assertEquals(expected, testConfig.imagesPerPage)
    }

    @Test
    fun passingZeroRowsOrColumnsShouldThrowCollageConfigurationZeroRowsOrColumnsException() {
        assertThrows<CollageConfigurationZeroRowsOrColumnsException> {
            CollageConfiguration(PictureOrientation.VERTICAL, 0, 5)
        }

        assertThrows<CollageConfigurationZeroRowsOrColumnsException> {
            CollageConfiguration(PictureOrientation.VERTICAL, 5, 0)
        }

        assertThrows<CollageConfigurationZeroRowsOrColumnsException> {
            CollageConfiguration(PictureOrientation.VERTICAL, 0, 0)
        }
    }

    @Test
    fun passingNegativeRowsOrColumnsShouldThrowCollageConfigurationNegativeRowsOrColumnsException() {
        assertThrows<CollageConfigurationNegativeRowsOrColumnsException> {
            CollageConfiguration(PictureOrientation.VERTICAL, -1, 5)
        }

        assertThrows<CollageConfigurationNegativeRowsOrColumnsException> {
            CollageConfiguration(PictureOrientation.VERTICAL, 5, -1)
        }

        assertThrows<CollageConfigurationNegativeRowsOrColumnsException> {
            CollageConfiguration(PictureOrientation.VERTICAL, -1, -1)
        }
    }
}