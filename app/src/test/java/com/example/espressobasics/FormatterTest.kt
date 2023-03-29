package com.example.espressobasics

import com.example.espressobasics.text.Formatter
import com.example.espressobasics.text.Formatter.Format
import org.junit.Assert.assertEquals
import org.junit.Test

class FormatterTest {

    private val text = "    Hello World!    "

    @Test
    fun `test when format is UPPER_CASE`() {
        val expected = "HELLO WORLD!"

        assertEquals(expected, Formatter.format(text, Format.UPPER_CASE))
    }

    @Test
    fun `test when format is LOWER_CASE`() {
        val expected = "hello world!"

        assertEquals(expected, Formatter.format(text, Format.LOWER_CASE))
    }

    @Test
    fun `test when format is DEFAULT`() {
        val expected = "Hello World!"

        assertEquals(expected, Formatter.format(text, Format.DEFAULT))
    }

    @Test
    fun `test when format is not provided`() {
        val expected = "Hello World!"

        assertEquals(expected, Formatter.format(text))
    }

    @Test
    fun `test when text is blank`() {
        val expected = "Empty text, please enter some text and try again!"

        assertEquals(expected, Formatter.format("   "))
    }
}