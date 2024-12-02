package nl.mythiccoding.day01

import readInput
import kotlin.math.abs

fun main() {
    val input = readInput("day_01")

    val (leftList, rightList) = input.map { comb ->
        val split = comb.split("   ")
        split[0].toInt() to split[1].toInt()
    }.unzip()

    val sortedLeftList = leftList.sorted()
    val sortedRightList = rightList.sorted()

    val distances = sortedLeftList.zip(sortedRightList).sumOf { (a, b) -> abs(a - b) }
    println(distances)
}