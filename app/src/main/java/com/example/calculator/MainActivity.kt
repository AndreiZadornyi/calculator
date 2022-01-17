package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value: Double = 0.0
    var operation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
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
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "0"
            } else {
                screen.text = "0"
            }
        }

        btn_1.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "1"
            } else {
                screen.text = "1"
            }
        }

        btn_2.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "2"
            } else {
                screen.text = "2"
            }
        }

        btn_3.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "3"
            } else {
                screen.text = "3"
            }
        }

        btn_4.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "4"
            } else {
                screen.text = "4"
            }
        }

        btn_5.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "5"
            } else {
                screen.text = "5"
            }
        }

        btn_6.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "6"
            } else {
                screen.text = "6"
            }
        }

        btn_7.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "7"
            } else {
                screen.text = "7"
            }
        }

        btn_8.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "8"
            } else {
                screen.text = "8"
            }
        }

        btn_9.setOnClickListener {
            var temp = screen.text.toString()

            if (temp != "0" && operation == null) {
                screen.text = temp + "9"
            } else {
                screen.text = "9"
            }
        }

        btn_c.setOnClickListener {
            screen.text = "0"
            operation = null
        }

        btn_percent.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "%"
        }

        btn_backspace.setOnClickListener {

            if (screen.text.length < 2) {
                screen.text = "0"
            } else {
                screen.text = screen.text.substring(0, screen.text.length - 1)
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

        btn_equals.setOnClickListener {

            var temp = (screen.text as String).toDouble()

            when (operation) {
                "%" -> {
                    screen.text = (value / 100 * temp).toString()
                    operation = null
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
        }
    }
}