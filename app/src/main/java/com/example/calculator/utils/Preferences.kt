package com.example.calculator.utils

import android.content.Context
import com.example.calculator.models.LogResult
import com.example.calculator.models.ResultItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Preferences(private val context: Context) {

    fun setLogResult(logs: ArrayList<ResultItem>?) {
        var s = ""
        if (logs != null) {
            val gson = Gson()
            s = gson.toJson(logs)
        }
        val edit = context.getSharedPreferences("preferences", 0).edit()
        edit.putString("result", s)
        edit.apply()
    }

    fun getLogResult(): ArrayList<ResultItem>? {
        val gson = Gson()
        val s = context.getSharedPreferences("preferences", 0)
            .getString("result", null)
        return if (s != null) {
            gson.fromJson(
                s,
                object : TypeToken<ArrayList<ResultItem>?>() {}.type
            )
        } else null
    }

    fun addItem(logItem: ResultItem): ArrayList<ResultItem> {
        var logs = getLogResult()


        if (logs == null) {
            logs = ArrayList<ResultItem>()
        }
        logs.add(logItem)
        setLogResult(logs)
        return logs
    }

}