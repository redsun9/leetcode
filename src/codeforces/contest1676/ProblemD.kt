@file:Suppress("DuplicatedCode")

package codeforces.contest1676

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val m = nextInt()
        val arr = Array(n) { nextInts(m) }
        println(solve(arr))
    }
}

fun solve(arr: Array<IntArray>): Long {
    val m = arr.size
    val n = arr[0].size

    // x+y = (0, m+n-2)
    val d1 = LongArray(m + n - 1)
    // x-y + n-1  = (0, m+n-2)
    val d2 = LongArray(m + n - 1)
    for (i in 0 until m) {
        for (j in 0 until n) {
            d1[i + j] = d1[i + j] + arr[i][j]
            d2[i - j + n - 1] = d2[i - j + n - 1] + arr[i][j]
        }
    }

    var ans = Long.MIN_VALUE
    for (i in 0 until m) {
        for (j in 0 until n) {
            ans = max(ans, d1[i + j] + d2[i - j + n - 1] - arr[i][j])
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