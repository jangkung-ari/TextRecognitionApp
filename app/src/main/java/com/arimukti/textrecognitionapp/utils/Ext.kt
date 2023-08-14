package com.arimukti.textrecognitionapp.utils

import androidx.lifecycle.MutableLiveData

object Ext {
    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

//    fun calc(text: String) {
//        val text = "This text contains some arithmetic expressions like 2 + 3 and 10 * 5."
//
//        val arithmeticRegex = Regex("[0-9]+\\s*[-+*/]\\s*[0-9]+")
//        val match = arithmeticRegex.find(text)
//
//        if (match != null) {
//            val expression = match.value
//            val result = evaluateArithmetic(expression)
//            println("$expression = $result")
//        } else {
//            println("No arithmetic expression found in the text.")
//        }
//    }
//
//    private fun evaluateArithmetic(expression: String): Double {
//        val operators = setOf("+", "-", "*", "/")
//        val operator = operators.find { expression.contains(it) }
//        if (operator != null) {
//            val parts = expression.split(operator)
//            val leftOperand = parts[0].trim().toDouble()
//            val rightOperand = parts[1].trim().toDouble()
//
//            return when (operator) {
//                "+" -> leftOperand + rightOperand
//                "-" -> leftOperand - rightOperand
//                "*" -> leftOperand * rightOperand
//                "/" -> leftOperand / rightOperand
//                else -> Double.NaN
//            }
//        }
//        return Double.NaN
//    }
}