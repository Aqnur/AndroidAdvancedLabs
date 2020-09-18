package com.example.calculatormvp.model

class Operand {

    private val emptyValue = "0"
    private var mValue = emptyValue

    fun setValue(value: String) {
        mValue = value
    }

    fun getValue(): String {
        return mValue
    }

    fun appendValue(value: String) {
        if (mValue == emptyValue) {
            mValue = value
        } else {
            mValue += value
        }
    }

    fun deleteDigit() {
        mValue = if (mValue.length == 1) {
            emptyValue
        } else {
            mValue.substring(0, mValue.length - 1)
        }
    }

    fun reset() {
        mValue = emptyValue
    }
}