package com.example.calculator.models

import com.google.gson.annotations.SerializedName

class ResultItem {
    @SerializedName("result")
    var result: String = ""
}

class LogResult() {
    @SerializedName("results")
    var logs: ArrayList<ResultItem>? = null
}