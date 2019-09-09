package be.mickverm.common.extensions

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class ArrayExtTest {

    data class Item(
            var id: Int,
            var text: String
    )

    @Test
    fun stringArray_ShouldMatch_ExpectedArray_AfterMapInPlace() {
        var actual = arrayOf("a", "b", "c", "d")
        val expected = arrayOf("aa", "bb", "cc", "dd")

        actual = actual.mapInPlace { value ->
            "$value$value"
        }

        assertEquals(expected.size, actual.size)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun intArray_ShouldMatch_ExpectedArray_AfterMapInPlace() {
        var actual = arrayOf(1, 2, 3, 4)
        val expected = arrayOf(2, 4, 6, 8)

        actual = actual.mapInPlace { value ->
            value * 2
        }

        assertEquals(expected.size, actual.size)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun objectArray_ShouldMatch_ExpectedArray_AfterMapInPlace() {
        var actual = arrayOf(
                Item(1, "Item"),
                Item(2, "Item"),
                Item(3, "Item"),
                Item(4, "Item")
        )
        val expected = arrayOf(
                Item(2, "Item2"),
                Item(4, "Item4"),
                Item(6, "Item6"),
                Item(8, "Item8")
        )

        actual = actual.mapInPlace { item ->
            item.apply {
                id *= 2
                text += id
            }
        }

        assertEquals(expected.size, actual.size)
        assertArrayEquals(expected, actual)
    }
}