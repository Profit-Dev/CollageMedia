package exceptions.collageConfiguration

/**
 * Exception thrown when a `CollageConfiguration` has zero rows or columns.
 *
 * This exception is used to indicate that a collage cannot be created
 * because the number of rows or columns specified is zero, which is
 * considered an invalid configuration.
 *
 * @param message A detailed message describing the error condition.
 */
class CollageConfigurationZeroRowsOrColumnsException(message: String) : Exception(message)