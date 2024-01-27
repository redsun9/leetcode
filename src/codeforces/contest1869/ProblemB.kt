@file:Suppress("DuplicatedCode")

package codeforces.contest1869

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val k = nextInt()
        val a = nextInt() - 1
        val b = nextInt() - 1
        val arr = Array(n) { nextLongs(2) }
        println(solve(arr, a, b, k))
    }
}

fun solve(arr: Array<LongArray>, a: Int, b: Int, k: Int): Long {
    val d3 = abs(arr[a][0] - arr[b][0]) + abs(arr[a][1] - arr[b][1])
    if (k <= 1) return d3
    val d1 = IntRange(0, k - 1).minOf { i -> abs(arr[i][0] - arr[a][0]) + abs(arr[i][1] - arr[a][1]) }
    val d2 = IntRange(0, k - 1).minOf { i -> abs(arr[i][0] - arr[b][0]) + abs(arr[i][1] - arr[b][1]) }
    return min(d1 + d2, d3)
}


private class MyReader(inputStream: InputStream) {
    private val reader = BufferedReader(InputStreamReader(inputStream))
    private var tokenizer: StringTokenizer? = null

    fun next(): String {
        while (true) {
            tokenizer.let {
                if (it == null || !it.hasMoreTokens()) {
                    tokenizer = StringTokenizer(reader.readLine())
                } else {
                    return it.nextToken()
                }
            }
        }
    }
}

private val reader = MyReader(System.`in`)
private fun next() = reader.next()
private fun nextInt() = next().toInt()
private fun nextLong() = next().toLong()
private fun nextDouble() = next().toDouble()
private fun nextStrings(n: Int) = Array(n) { next() }
private fun nextInts(n: Int) = IntArray(n) { nextInt() }
private fun nextLongs(n: Int) = LongArray(n) { nextLong() }
private fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }