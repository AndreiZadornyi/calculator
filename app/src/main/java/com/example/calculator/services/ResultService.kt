package com.example.calculator.services

import android.annotation.SuppressLint
import android.content.Context
import com.example.calculator.MainActivity
import com.example.calculator.models.ResultItem
import com.example.calculator.utils.Preferences

class ResultService {

    fun addItem(value: String) {

        val item = ResultItem()

        item.result = value


        _context?.let { Preferences(it).addItem(item) }

        if (logListener != null) {
            logListener?.addLog(item)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var _context: Context? = null
        var logListener: MainActivity.LogInterfece? = null


        fun initLogListener(_logListener: MainActivity.LogInterfece) {
            logListener = _logListener
        }

        fun destLogListener() {
            logListener = null
        }

    }
}