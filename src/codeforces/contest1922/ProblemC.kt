@file:Suppress("DuplicatedCode")

package codeforces.contest1922

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val a = nextInts(n)
        val m = nextInt()
        val queries = Array(m) { nextInt() - 1 to nextInt() - 1 }
        solve(a, queries).forEach(::println)
    }
}

fun solve(a: IntArray, queries: Array<Pair<Int, Int>>): List<Int> {
    val n = a.size
    val pref = IntArray(n)
    pref[1] = 1
    for (i in 2 until n) pref[i] = pref[i - 1] + if (a[i] - a[i - 1] <= a[i - 1] - a[i - 2]) 1 else a[i] - a[i - 1]

    val suff = IntArray(n)
    suff[n - 2] = 1
    for (i in n - 3 downTo 0) suff[i] = suff[i + 1] + if (a[i + 1] - a[i] <= a[i + 2] - a[i + 1]) 1 else a[i + 1] - a[i]

    return queries.map { if (it.first < it.second) pref[it.second] - pref[it.first] else suff[it.second] - suff[it.first] }
}

private class MyReader1(inputStream: InputStream) {
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

private val reader = MyReader1(System.`in`)
private fun next() = reader.next()
private fun nextInt() = next().toInt()
private fun nextLong() = next().toLong()
private fun nextDouble() = next().toDouble()
private fun nextStrings(n: Int) = Array(n) { next() }
private fun nextInts(n: Int) = IntArray(n) { nextInt() }
private fun nextLongs(n: Int) = LongArray(n) { nextLong() }
private fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }