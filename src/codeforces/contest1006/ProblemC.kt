@file:Suppress("DuplicatedCode")

package codeforces.contest1006

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val n = nextInt()
    println(solve(nextInts(n)))
}

fun solve(arr: IntArray): Long {
    if (arr.size <= 1) return 0L
    var ans = 0L
    var l = 1
    var r = arr.size - 1
    var leftSum = arr[0].toLong()
    var rightSum = 0L
    while (l <= r) {
        if (leftSum <= rightSum) leftSum += arr[l++]
        else rightSum += arr[r--]
        if (leftSum == rightSum) ans = leftSum
    }
    return ans
}


private class MyReader2(inputStream: InputStream) {
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

private val reader = MyReader2(System.`in`)
private fun next() = reader.next()
private fun nextInt() = next().toInt()
private fun nextLong() = next().toLong()
private fun nextDouble() = next().toDouble()
private fun nextStrings(n: Int) = Array(n) { next() }
private fun nextInts(n: Int) = IntArray(n) { nextInt() }
private fun nextLongs(n: Int) = LongArray(n) { nextLong() }
private fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }