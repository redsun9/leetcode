@file:Suppress("DuplicatedCode", "ConvertTwoComparisonsToRangeCheck")

package codeforces.contest1541

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val arr = nextInts(n)
        println(solve(arr))
    }
}

fun solve(arr: IntArray): Int {
    val n = arr.size
    val maxSum = n * 2
    var ans = 0
    for ((i, ai) in arr.withIndex()) {
        val threshold = min(ai - 1, maxSum / ai)
        for (aj in 1 until threshold + 1) {
            val j = ai * aj - i - 2
            if (j >= 0 && j < n && arr[j] == aj) ans++
        }
    }
    return ans
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