package models

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
    fun passingZeroRowsOrColumnsShouldThrowAnException() {
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
}