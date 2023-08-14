package com.arimukti.textrecognitionapp.utils

import androidx.lifecycle.MutableLiveData

object Ext {
    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

    fun calc(text: String) : Pair<String, Int> {
        var a = 0
        var expres = ""
        val arithmeticRegex = Regex("[0-9]+\\s*[-+*/]\\s*[0-9]+")
        val match = arithmeticRegex.find(text)

        if (match != null) {
            val expression = match.value
            val result = evaluateArithmetic(expression)
            println("$expression = $result")
            a = result.toInt()
            expres = expression
        } else {
            println("No arithmetic expression found in the text.")
        }
        return Pair(expres, a)
    }

    private fun evaluateArithmetic(expression: String): Double {
        val operators = setOf("+", "-", "*", "/")
        val operator = operators.find { expression.contains(it) }
        if (operator != null) {
            val parts = expression.split(operator)
            val leftOperand = parts[0].trim().toDouble()
            val rightOperand = parts[1].trim().toDouble()

            return when (operator) {
                "+" -> leftOperand + rightOperand
                "-" -> leftOperand - rightOperand
                "*" -> leftOperand * rightOperand
                "/" -> leftOperand / rightOperand
                else -> Double.NaN
            }
        }
        return Double.NaN
    }
}