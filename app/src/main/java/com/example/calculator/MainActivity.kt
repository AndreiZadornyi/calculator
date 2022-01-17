package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value: Double = 0.0
    var operation: String? = null
    var position_delimiter: Int? = null
    var number: Int? = null
    var flag_delimiter: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    fun inputNumber(number: Int) {

        when {
            position_delimiter != null && flag_delimiter == true -> {
                flag_delimiter = false
                screen.text = screen.text.substring(0, screen.text.length - 1) + number
            }
            screen.text.toString() != "0" && operation == null -> {

                screen.text = screen.text.toString() + number.toString()
            }
            else -> {
                screen.text = number.toString()
            }

        }

    }

    fun setupView() {

        screen.text = "0"

        btn_00.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "00"
            } else {
                screen.text = "0"
            }
        }

        btn_0.setOnClickListener {


            if (screen.text.toString() != "0" && operation == null) {
                screen.text = screen.text.toString() + "0"
            } else {
                screen.text = "0"
            }
        }

        btn_1.setOnClickListener {
            inputNumber(1)
        }

        btn_2.setOnClickListener {
            inputNumber(2)
        }

        btn_3.setOnClickListener {
            inputNumber(3)
        }

        btn_4.setOnClickListener {
            inputNumber(4)
        }

        btn_5.setOnClickListener {
            inputNumber(5)
        }

        btn_6.setOnClickListener {
            inputNumber(6)
        }

        btn_7.setOnClickListener {
            inputNumber(7)
        }

        btn_8.setOnClickListener {
            inputNumber(8)
        }

        btn_9.setOnClickListener {
            inputNumber(9)
        }

        btn_c.setOnClickListener {
            screen.text = "0"
            operation = null
            position_delimiter = null
            value = 0.0
        }

        btn_percent.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "%"
        }

        btn_backspace.setOnClickListener {

            when {
                position_delimiter == screen.text.length - 2 -> {
                    screen.text = screen.text.substring(0, screen.text.length - 2)
                    position_delimiter = null
                }
                screen.text.length < 2 -> {
                    screen.text = "0"
                }
                else -> {
                    screen.text = screen.text.substring(0, screen.text.length - 1)
                }
            }
        }

        btn_addition.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "+"
        }

        btn_subtraction.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "-"
        }

        btn_multiply.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "*"
        }

        btn_delimiter.setOnClickListener {
            if (position_delimiter == null) {
                flag_delimiter = true
                position_delimiter = screen.text.length
                screen.text = screen.text.toString() + ".0"
            }
        }

        btn_equals.setOnClickListener {

            var temp = (screen.text as String).toDouble()

            when (operation) {
                "%" -> {
                    screen.text = (value / 100 * temp).toString()
                }
                "/" -> {
                    screen.text = (value / temp).toString()
                }
                "+" -> {
                    screen.text = (value + temp).toString()
                }
                "-" -> {
                    screen.text = (value - temp).toString()
                }
                "*" -> {
                    screen.text = (value * temp).toString()
                }
            }

            operation = null
        }
    }
}