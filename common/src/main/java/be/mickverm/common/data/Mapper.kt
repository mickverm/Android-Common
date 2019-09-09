package be.mickverm.common.data

interface Mapper<I, O> {
    fun map(input: I): O
}
