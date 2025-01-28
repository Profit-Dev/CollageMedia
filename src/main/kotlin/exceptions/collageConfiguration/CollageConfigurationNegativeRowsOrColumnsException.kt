package exceptions.collageConfiguration

/**
 * Exception thrown when a negative value is provided for rows or columns in the collage configuration.
 *
 * This exception is used to indicate invalid input for the number of rows or columns,
 * as both values must be positive integers.
 *
 * @param message A detailed message describing the error condition.
 */
class CollageConfigurationNegativeRowsOrColumnsException(message: String) : Exception(message)