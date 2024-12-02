package nl.mythiccoding.day02

import readInput
import kotlin.math.abs

fun main() {
    val input = readInput("day_02")

    val analyzedReports = input.map { report ->
        val numbers = report.split(" ").map { it.toInt() }
        var isSafe = false

        numbers.forEachIndexed { index, i ->
            val filteredNumbers = numbers.filterIndexed { idx, _ -> idx != index }
            if (allAscendingOrDescending(filteredNumbers) && isSafeDiff(filteredNumbers)) {
                isSafe = true
                return@forEachIndexed
            }
        }
        isSafe
    }
    println(analyzedReports.count { it })
}

private fun allAscendingOrDescending(nums: List<Int>): Boolean {
    val isAscending = nums.zipWithNext().all { (a, b) -> a < b }
    val isDescending = nums.zipWithNext().all { (a, b) -> a > b }
    return isAscending || isDescending
}

private fun isSafeDiff(nums: List<Int>): Boolean {
    return nums.zipWithNext().all { (a, b) -> abs(a - b) <= 3 }
}