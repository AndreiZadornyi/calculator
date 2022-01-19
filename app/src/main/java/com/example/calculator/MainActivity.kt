package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.adapters.ItemListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value: Double = 0.0
    var operation: String? = null
    var position_delimiter: Int? = null
    var two_null: Boolean? = false

    val reg_ex_delimiter = Regex("[.]+")
    val reg_ex_find_delimiter = Regex("[.][0-9]{1}$+")

    private var adapter: ItemListAdapter? = null

    //    var number: Int? = null
    var flag_delimiter: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    fun inputNumber(number: String) {

        when {

            number == ".0" && !reg_ex_delimiter.containsMatchIn(screen.text.toString()) -> {
                screen.text = screen.text.toString() + number
            }

            number == "00" && screen.text.toString() != "0" -> {
                screen.text = screen.text.toString() + number
            }

            number == "0" && screen.text.toString() != "0" -> {
                screen.text = screen.text.toString() + number
            }

            screen.text.toString() == "0" && number != "00"-> {
                screen.text = number
            }

            screen.text.toString() != "0" && number != "00" -> {
                screen.text = screen.text.toString() + number
            }
        }
//
//
////            flag_delimiter == true -> {
////                flag_delimiter = false
////                if (number == 0) {
////                    screen.text = screen.text.toString() + "0"
////                } else {
////                    screen.text = screen.text.substring(0, screen.text.length - 1) + number
////                }
////            }
//
////            screen.text.toString() != "0" && operation == null -> {
////                if (two_null == true) {
////                    screen.text = screen.text.toString() + "00"
////                    two_null = false
////                } else {
////                    screen.text = screen.text.toString() + number.toString()
////                }
////            }
//            else -> {
//                screen.text = number.toString()
//            }


    }

    fun setupView() {

        screen.text = "0"

        btn_00.setOnClickListener {
            inputNumber("00")
        }

        btn_0.setOnClickListener {
            inputNumber("0")
        }

        btn_1.setOnClickListener {
            inputNumber("1")
        }

        btn_2.setOnClickListener {
            inputNumber("2")
        }

        btn_3.setOnClickListener {
            inputNumber("3")
        }

        btn_4.setOnClickListener {
            inputNumber("4")
        }

        btn_5.setOnClickListener {
            inputNumber("5")
        }

        btn_6.setOnClickListener {
            inputNumber("6")
        }

        btn_7.setOnClickListener {
            inputNumber("7")
        }

        btn_8.setOnClickListener {
            inputNumber("8")
        }

        btn_9.setOnClickListener {
            inputNumber("9")
        }

        btn_delimiter.setOnClickListener {
            inputNumber(".0")
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
                reg_ex_find_delimiter.containsMatchIn(screen.text.toString()) -> {
                    screen.text = screen.text.substring(0, screen.text.length - 2)
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