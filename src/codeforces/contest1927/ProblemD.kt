@file:Suppress("DuplicatedCode")

package codeforces.contest1927

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val arr = nextInts(nextInt())
        val queries = Array(nextInt()) { nextInt() - 1 to nextInt() - 1 }
        solve(arr, queries).forEach { (l, r) ->
            if (l == -1) println("-1 -1")
            else println("${l + 1} ${r + 1}")
        }
    }
}

fun solve(arr: IntArray, queries: Array<Pair<Int, Int>>): List<Pair<Int, Int>> {
    val n = arr.size
    val firstLeft = IntArray(n)
    firstLeft[0] = -1
    for (i in 1 until n) {
        if (arr[i] != arr[i - 1]) firstLeft[i] = i - 1
        else firstLeft[i] = firstLeft[i - 1]
    }
    return queries.map { (l, r) ->
        if (firstLeft[r] >= l) firstLeft[r] to r
        else -1 to -1
    }
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