package com.example.calculatormvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculatormvp.R
import com.example.calculatormvp.contract.ContractInterface
import com.example.calculatormvp.model.Operand
import com.example.calculatormvp.presenter.Calculator
import com.example.calculatormvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), ContractInterface.View {

    private lateinit var mPresenter: ContractInterface.Presenter
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var clear: Button
    private lateinit var add: Button
    private lateinit var subtract: Button
    private lateinit var multiply: Button
    private lateinit var divide: Button
    private lateinit var equal: Button
    private lateinit var input: TextView
    private lateinit var sign: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        onClickListener()

        mPresenter = MainPresenter(Calculator(), this,  Operand(), Operand())
    }

    private fun initViews() {
        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        add = findViewById(R.id.plus)
        subtract = findViewById(R.id.minus)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        equal = findViewById(R.id.equal)
        clear = findViewById(R.id.clear)
        input = findViewById(R.id.input)
        sign = findViewById(R.id.sign)
    }

    private fun onClickListener() {
        zero.setOnClickListener { mPresenter.appendValue(zero.text.toString()) }
        one.setOnClickListener { mPresenter.appendValue(one.text.toString()) }
        two.setOnClickListener { mPresenter.appendValue(two.text.toString()) }
        three.setOnClickListener { mPresenter.appendValue(three.text.toString()) }
        four.setOnClickListener { mPresenter.appendValue(four.text.toString()) }
        five.setOnClickListener { mPresenter.appendValue(five.text.toString()) }
        six.setOnClickListener { mPresenter.appendValue(six.text.toString()) }
        seven.setOnClickListener { mPresenter.appendValue(seven.text.toString()) }
        eight.setOnClickListener { mPresenter.appendValue(eight.text.toString()) }
        nine.setOnClickListener { mPresenter.appendValue(nine.text.toString()) }

        add.setOnClickListener { mPresenter.appendOperator(add.text.toString()) }
        subtract.setOnClickListener { mPresenter.appendOperator(subtract.text.toString()) }
        divide.setOnClickListener { mPresenter.appendOperator(divide.text.toString()) }
        multiply.setOnClickListener { mPresenter.appendOperator(multiply.text.toString()) }

        clear.setOnClickListener { mPresenter.clearCalculation() }

        equal.setOnClickListener { mPresenter.performCalculation() }
    }

    override fun displayOperand(calculation: String) {
        input.text = calculation
    }

    override fun displayOperator(operator: String) {
        sign.text = operator
    }

}