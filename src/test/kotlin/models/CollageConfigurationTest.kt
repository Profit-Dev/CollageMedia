package models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CollageConfigurationTest {
    @Test
    fun positiveRowsAndColumnsShouldsCalculateImagesPerPageCorrectly() {
        val rows = 5
        val columns = 6
        val expected = 30

        val testConfig = CollageConfiguration(PictureOrientation.VERTICAL, rows, columns)

        assertEquals(expected, testConfig.imagesPerPage)
    }
}