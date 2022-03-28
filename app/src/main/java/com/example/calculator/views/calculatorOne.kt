package com.example.calculator

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_calculator_one.*
import kotlinx.android.synthetic.main.fragment_calculator_one.view.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class calculatorOne : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_bracket_left_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        button_division.setOnClickListener {
            input.text = addToInputText("÷")
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText("×")
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }

        view.button_equals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                //Ошибка
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(view!!.context , R.color.red))
            } else {
                // Результат
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(view!!.context, R.color.green))
            }
        } catch (e: Exception) {
            // Ошибка
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(view!!.context, R.color.red))
        }
    }
    }

