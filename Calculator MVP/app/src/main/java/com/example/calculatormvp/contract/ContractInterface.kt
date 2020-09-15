package com.example.calculatormvp.contract

import com.example.calculatormvp.model.Operator

interface ContractInterface {
    interface View {
        fun displayOperand(calculation: String)
        fun displayOperator(operator: String)
    }

    interface Presenter {
        fun clearCalculation()
        fun getOperator(): Operator
        fun appendValue(value: String)
        fun appendOperator(operator: String)
        fun performCalculation()
    }
}