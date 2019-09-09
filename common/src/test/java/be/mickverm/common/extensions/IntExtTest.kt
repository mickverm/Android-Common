package be.mickverm.common.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class IntExtTest {

    @Test
    fun test_IntToBoolean() {
        assertEquals(true, 1.toBoolean())
        assertEquals(false, 0.toBoolean())
        assertEquals(false, 10.toBoolean())
        assertEquals(true, 10.toBoolean(10))
    }
}