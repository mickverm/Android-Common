package be.mickverm.common.extensions

fun Boolean.toInt(falseValue: Int = 0, trueValue: Int = 1): Int {
    require(falseValue != trueValue) {
        "FalseValue can't be equal to trueValue!"
    }
    return if (this) trueValue else falseValue
}