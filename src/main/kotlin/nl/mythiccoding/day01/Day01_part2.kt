package nl.mythiccoding.day01

import readInput
import kotlin.math.abs

fun main() {
    val input = readInput("day_01")

    val (leftList, rightList) = input.map { comb ->
        val split = comb.split("   ")
        split[0].toInt() to split[1].toInt()
    }.unzip()

    val grouped = rightList.groupingBy { it }.eachCount()

    val similarityScore = leftList.sumOf { num ->
        num * (grouped[num] ?: 0)
    }

    println(similarityScore)
}