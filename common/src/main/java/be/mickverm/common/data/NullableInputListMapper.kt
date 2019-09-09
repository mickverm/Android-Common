package be.mickverm.common.data

interface NullableInputListMapper<I, O> : Mapper<List<I>?, List<O>>

class NullabelInputListMapperImpl<I, O>(
        private val mapper: Mapper<I, O>
) : NullableInputListMapper<I, O> {

    constructor(mapper: (input: I) -> O) : this(object : Mapper<I, O> {
        override fun map(input: I): O = mapper.invoke(input)
    })

    override fun map(input: List<I>?): List<O> = input?.map { mapper.map(it) }.orEmpty()
}
