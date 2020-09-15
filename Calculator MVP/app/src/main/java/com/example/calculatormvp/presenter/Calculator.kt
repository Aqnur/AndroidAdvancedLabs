package com.example.calculatormvp.presenter

import com.example.calculatormvp.model.Operand
import kotlin.math.pow
import kotlin.math.roundToInt


class Calculator {

    fun add(firstOperand: Operand, secondOperand: Operand) : String {
        val result: Double = getValue(firstOperand) + getValue(secondOperand)
//        return result.toString()
        return formatResult(result)
    }

    fun subtract(firstOperand: Operand, secondOperand: Operand) : String {
        val result: Double = getValue(firstOperand) - getValue(secondOperand)
//        return result.toString()
        return formatResult(result)
    }

    fun divide(firstOperand: Operand, secondOperand: Operand) : String {
        val result: Double = getValue(firstOperand) / getValue(secondOperand)
//        return result.toString()
        return formatResult(result)
    }

    fun multiply(firstOperand: Operand, secondOperand: Operand) : String {
        val result: Double = getValue(firstOperand) * getValue(secondOperand)
//        return result.toString()
        return formatResult(result)
    }

    private fun getValue(operand: Operand): Double {
        return java.lang.Double.valueOf(operand.getValue())
    }

    private fun formatResult(res: Double) : String {
        val digits = 10.0.pow(1.0)
        val res2 = (res * digits).roundToInt() / digits

        var result = res2.toString()
        var decimals = result.substring(0, result.indexOf("."))
        var fractionals = result.substring(result.indexOf(".") + 1)

        while (fractionals.isNotEmpty() && fractionals.substring(fractionals.length - 1) == "0") {
            fractionals = fractionals.substring(0, fractionals.length - 1)
        }

        if (fractionals.isNotEmpty()) {
            return "$decimals.$fractionals"
        } else {
            return decimals
        }
    }
}