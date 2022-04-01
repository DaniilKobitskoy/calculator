package com.example.calculatorGood.views

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import com.example.calculatorGood.R

import kotlinx.android.synthetic.main.fragment_calculator_num_two.*


var oper = ""
class calculatorNumTwo : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator_num_two, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                var btnAdd = view?.findViewById<Button>(R.id.btnAdd)
        var btnSub = view?.findViewById<Button>(R.id.btnSub)
        var btnMult = view?.findViewById<Button>(R.id.btnMult)
        var btnDiv = view?.findViewById<Button>(R.id.btnDiv)
        btnAdd?.setOnClickListener(this)
        btnSub?.setOnClickListener(this)
        btnMult?.setOnClickListener(this)
        btnDiv?.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        var num1 = 0f
        var num2 = 0f
        var result = 0f
        if (TextUtils.isEmpty(etNum1?.text.toString())
            || TextUtils.isEmpty(etNum2?.text.toString())
        ) {
            return
        }

        num1 = etNum1?.text.toString().toFloat()
        num2 = etNum2?.text.toString().toFloat()

        when (v.id) {
           R.id.btnAdd -> {
             oper = "+"
                result = num1 + num2
Log.d("кнопка", "привет")
            }
           R.id.btnSub -> {
               oper = "-"
                result = num1 - num2
               tvResult?.setText( result.toString())
            }
           R.id.btnMult -> {
               oper = "*"
                result = num1 * num2
               tvResult?.setText( result.toString())
            }
           R.id.btnDiv -> {
                oper = "/"
                result = num1 / num2
               tvResult?.setText( result.toString())
            }
            else -> {}
        }

        tvResult.text = "$result"
    }


}