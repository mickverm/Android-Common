package be.mickverm.common.extensions

inline fun <T> MutableList<T>.mapInPlace(mutator: (T) -> T): MutableList<T> {
    val iterate = this.listIterator()
    while (iterate.hasNext()) {
        val oldValue = iterate.next()
        val newValue = mutator(oldValue)
        if (newValue !== oldValue) {
            iterate.set(newValue)
        }
    }
    return this
}