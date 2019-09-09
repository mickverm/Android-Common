package be.mickverm.common.data

interface ListMapper<I, O> : Mapper<List<I>, List<O>>

class ListMapperImpl<I, O>(
        private val mapper: Mapper<I, O>
) : ListMapper<I, O> {

    constructor(mapper: (input: I) -> O) : this(object : Mapper<I, O> {
        override fun map(input: I): O = mapper.invoke(input)
    })

    override fun map(input: List<I>): List<O> = input.map { mapper.map(it) }
}
