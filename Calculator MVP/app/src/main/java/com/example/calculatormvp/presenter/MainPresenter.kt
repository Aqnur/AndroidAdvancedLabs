package com.example.calculatormvp.presenter

import com.example.calculatormvp.contract.ContractInterface
import com.example.calculatormvp.model.Operand
import com.example.calculatormvp.model.Operator


class MainPresenter(
    private var mCalculator: Calculator,
    private var mView: ContractInterface.View,
    private var mCurrentOperand: Operand,
    private var mPreviousOperand: Operand
) : ContractInterface.Presenter {

    private var mOperator: Operator = Operator.EMPTY
    private val maxLength = 10
    private var hasLastInputOperator = false
    private var hasLastInputEquals = false
    private var isInErrorState = false

    override fun clearCalculation() {
        resetCalculator()
        updateDisplay()
    }

    override fun getOperator(): Operator {
        return mOperator
    }

    override fun appendValue(value: String) {
        when {
            hasLastInputOperator -> {
                mPreviousOperand.setValue(mCurrentOperand.getValue())
                mCurrentOperand.reset()
            }
            hasLastInputEquals -> {
                resetCalculator()
            }
            else -> {
                mOperator = Operator.EMPTY
            }
        }

        if (mCurrentOperand.getValue().length < maxLength) {
            mCurrentOperand.appendValue(value)
            hasLastInputOperator = false
            hasLastInputEquals = false
            isInErrorState = false
            updateDisplay()
        }
    }

    override fun appendOperator(operator: String) {
        if (!isInErrorState) {
            if (mOperator != Operator.EMPTY && !hasLastInputOperator) {
                performCalculation()

                if (isInErrorState) {
                    return
                }
            }

            mOperator = Operator.getOperator(operator)
            hasLastInputOperator = true
            updateDisplay()
        }
    }

    override fun performCalculation() {
        val result: String = when (mOperator) {
            Operator.PLUS -> mCalculator.add(mPreviousOperand, mCurrentOperand)
            Operator.MINUS -> mCalculator.subtract(mPreviousOperand, mCurrentOperand)
            Operator.DIVIDE -> mCalculator.divide(mPreviousOperand, mCurrentOperand)
            Operator.MULTIPLY -> mCalculator.multiply(mPreviousOperand, mCurrentOperand)
            else -> {
                mCurrentOperand.getValue()
            }
        }

        if (result == "" || result.length > maxLength) {
            switchToErrorState()
        } else {
            mCurrentOperand.setValue(result)
        }

        mPreviousOperand.reset()
        mOperator = Operator.EMPTY
        hasLastInputEquals = true
        updateDisplay()
    }

    private fun switchToErrorState() {
        mCurrentOperand.setValue("ERROR")
        isInErrorState = true
    }

    private fun resetCalculator() {
        mCurrentOperand.reset()
        mPreviousOperand.reset()
        hasLastInputEquals = false
        hasLastInputOperator = false
        isInErrorState = false
        mOperator = Operator.EMPTY
    }

    private fun updateDisplay() {
        mView.displayOperand(mCurrentOperand.getValue())
        mView.displayOperator(mOperator.operator)
    }
}