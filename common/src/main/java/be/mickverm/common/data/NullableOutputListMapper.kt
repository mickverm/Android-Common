package be.mickverm.common.data

interface NullableOutputListMapper<I, O> : Mapper<List<I>, List<O>?>

class NullableOutputListMapperImpl<I, O>(
        private val mapper: Mapper<I, O>
) : NullableOutputListMapper<I, O> {

    constructor(mapper: (input: I) -> O) : this(object : Mapper<I, O> {
        override fun map(input: I): O = mapper.invoke(input)
    })

    override fun map(input: List<I>): List<O>? =
            if (input.isEmpty()) null else input.map { mapper.map(it) }
}
