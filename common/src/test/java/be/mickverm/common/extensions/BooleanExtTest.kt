package be.mickverm.common.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class BooleanExtTest {

    @Test
    fun test_BooleanToInt() {
        assertEquals(1, true.toInt())
        assertEquals(0, false.toInt())
        assertEquals(0, true.toInt(trueValue = 0, falseValue = 1))
        assertEquals(1, false.toInt(trueValue = 0, falseValue = 1))
        assertEquals(1, true.toInt(trueValue = 1, falseValue = 0))
        assertEquals(0, false.toInt(trueValue = 1, falseValue = 0))
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_BooleanToIntException() {
        true.toInt(0, 0)
    }
}