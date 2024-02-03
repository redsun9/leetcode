@file:Suppress("DuplicatedCode")

package codeforces.contest1901

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    println(solve(nextInts(nextInt())))
}

fun solve(a: IntArray): Int {
    val n = a.size
    val pref = IntArray(n) { i -> a[i] + (n - i - 1) }
    val suff = IntArray(n) { i -> a[i] + i }
    for (i in 1 until n) pref[i] = max(pref[i], pref[i - 1])
    for (i in n - 2 downTo 0) suff[i] = max(suff[i], suff[i + 1])
    var ans = Int.MAX_VALUE
    for (i in 0 until n) {
        var cur = a[i]
        if (i > 0) cur = max(cur, pref[i - 1])
        if (i + 1 < n) cur = max(cur, suff[i + 1])
        ans = min(ans, cur)
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