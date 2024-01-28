@file:Suppress("DuplicatedCode")

package codeforces.contest580

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val n = nextInt()
    val d = nextInt()
    val arr = Array(n) { nextInts(2) }
    val ans = solve(arr, d)
    println(ans)
}

fun solve(arr: Array<IntArray>, d: Int): Long {
    arr.sortBy { it[0] }
    var ans = 0L
    var left = 0
    var curSum = 0L
    for (friend in arr) {
        curSum += friend[1]
        while (arr[left][0] + d <= friend[0]) curSum -= arr[left++][1]
        ans = max(ans, curSum)
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