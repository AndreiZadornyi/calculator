package com.example.calculator

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.adapters.ItemListAdapter
import com.example.calculator.models.LogResult
import com.example.calculator.models.ResultItem
import com.example.calculator.utils.Preferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value: Double = 0.0
    var operation: String? = null

    val reg_ex_delimiter = Regex("[.]+")
    val reg_ex_delimiter_null = Regex("[.0]$+")
    val reg_ex_find_delimiter = Regex("[.][0-9]{1}$+")

    private var adapter: ItemListAdapter? = null
    private var items = Preferences(this)

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

            screen.text.toString() == "0" && number != "00" -> {
                screen.text = number
            }

            screen.text.toString() != "0" && reg_ex_delimiter_null.containsMatchIn(screen.text.toString()) -> {
                screen.text = screen.text.substring(0, screen.text.length - 1) + number
            }

            screen.text.toString() != "0" -> {
                screen.text = screen.text.toString() + number
            }
        }
    }

    fun showLogs() {
        if (adapter != null) {
            var temp = Preferences(applicationContext).getLogResult()
            if (temp != null && temp.size > 0) {
                adapter?.setItems(temp)
            }
        }
    }

    fun setupView() {

        adapter = ItemListAdapter()
        rv_result.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_result.adapter = adapter

        screen.text = "0"

        showLogs()

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
            value = 0.0
            items.onDestroy()
            showLogs()
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

        btn_percent.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "%"
            screen.text = "0"
        }

        btn_addition.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "+"
            screen.text = "0"
        }

        btn_subtraction.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "-"
            screen.text = "0"
        }

        btn_multiply.setOnClickListener {
            value = (screen.text as String).toDouble()
            operation = "*"
            screen.text = "0"
        }

        btn_equals.setOnClickListener {

            var result = ""

            when (operation) {
                "%" -> {
                    result = (value / 100 * (screen.text as String).toDouble()).toString()
                }
                "/" -> {
                    result = (value / (screen.text as String).toDouble()).toString()
                }
                "+" -> {
                    result = (value + (screen.text as String).toDouble()).toString()
                }
                "-" -> {
                    result = (value - (screen.text as String).toDouble()).toString()
                }
                "*" -> {
                    result = (value * (screen.text as String).toDouble()).toString()
                }
            }

            items.addItem(
                value.toString() +
                        operation +
                        ((screen.text.toString()).toDouble()).toString() +
                        "=" +
                        (screen.text.toString()).toDouble().toString()
            )

            screen.text = result
            showLogs()
            operation = null
        }
    }

}