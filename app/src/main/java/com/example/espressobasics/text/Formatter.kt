package com.example.espressobasics.text

import com.example.espressobasics.text.Formatter.Format.*

/**
 * A utility class for formatting text with different formats.
 */
class Formatter {
    /**
     * An enum class representing the available text formats.
     */
    enum class Format {
        UPPER_CASE, LOWER_CASE, DEFAULT
    }

    companion object {
        // A constant string to be returned if the input text is empty.
        private const val EMPTY_TEXT = "Empty text, please enter some text and try again!"

        /**
         * Formats the given [text] using the specified [format].
         *
         * @param text The text to format.
         * @param format The format to use for formatting the text.
         * @return The formatted text.
         */
        fun format(text: String, format: Format = DEFAULT): String {
            // If the input text is empty, return the empty text constant.
            val formattedText = if (text.isBlank()) EMPTY_TEXT else {
                // Otherwise, trim the text and apply the specified format.
                text.trim().let {
                    when (format) {
                        UPPER_CASE -> it.uppercase()
                        LOWER_CASE -> it.lowercase()
                        DEFAULT -> it
                    }
                }
            }
            // Return the formatted text.
            return formattedText
        }
    }
}