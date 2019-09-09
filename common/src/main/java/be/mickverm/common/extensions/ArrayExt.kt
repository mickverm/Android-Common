package be.mickverm.common.extensions

inline fun <T> Array<T>.mapInPlace(mutator: (T) -> T): Array<T> {
    for (i in indices) {
        this[i] = mutator(this[i])
    }
    return this
}