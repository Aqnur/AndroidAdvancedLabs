package com.example.calculatormvp.model

enum class Operator(var operator: String) {
    EMPTY(""),
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun getOperator(operator: String?): Operator {
            var op = EMPTY
            when (operator) {
                "+" -> op = PLUS
                "-" -> op = MINUS
                "*" -> op = MULTIPLY
                "/" -> op = DIVIDE
            }
            return op
        }
    }
}