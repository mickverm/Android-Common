package be.mickverm.common.extensions

import org.hamcrest.collection.IsIterableContainingInOrder.contains
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class ListExtTest {

    data class Item(
            var id: Int,
            var text: String
    )

    @Test
    fun stringList_ShouldMatch_ExpectedList_AfterMapInPlace() {
        var actual = mutableListOf("a", "b", "c", "d")
        val expected = mutableListOf("aa", "bb", "cc", "dd")

        actual = actual.mapInPlace { value ->
            "$value$value"
        }

        assertEquals(expected.size, actual.size)
        assertThat(actual, contains("aa", "bb", "cc", "dd"))
        assertEquals(expected, actual)
    }

    @Test
    fun intList_ShouldMatch_ExpectedList_AfterMapInPlace() {
        var actual = mutableListOf(1, 2, 3, 4)
        val expected = mutableListOf(2, 4, 6, 8)

        actual = actual.mapInPlace { value ->
            value * 2
        }

        assertEquals(expected.size, actual.size)
        assertThat(actual, contains(2, 4, 6, 8))
        assertEquals(expected, actual)
    }

    @Test
    fun objectList_ShouldMatch_ExpectedList_AfterMapInPlace() {
        var actual = mutableListOf(
                Item(1, "Item"),
                Item(2, "Item"),
                Item(3, "Item"),
                Item(4, "Item")
        )
        val expected = mutableListOf(
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
        assertThat(actual, contains(
                Item(2, "Item2"),
                Item(4, "Item4"),
                Item(6, "Item6"),
                Item(8, "Item8")
        ))
        assertEquals(expected, actual)
    }
}