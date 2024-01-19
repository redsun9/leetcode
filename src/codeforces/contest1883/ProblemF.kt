@file:Suppress("DuplicatedCode")

package codeforces.contest1883

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val arr = nextInts(n)
        println(solve(arr))
    }
}

fun solve(s: IntArray): Long {
    val first = s.withIndex().groupBy { it.value }.values.map { it.first().index }.sorted()
    val last = s.withIndex().groupBy { it.value }.values.map { it.last().index }.sorted()
    val n = first.size
    var ans = 0L
    var j = 0
    for (idx in first) {
        while (j < n && last[j] < idx) j++
        ans += n - j
    }
    return ans
}

fun solve2(s: IntArray): Long {
    val first = s.withIndex().fold(LinkedHashMap<Int, Int>()) { map, indexedValue ->
        map.putIfAbsent(indexedValue.value, indexedValue.index)
        map
    }.values.toList()

    val last = s.withIndex().fold(LinkedHashMap<Int, Int>()) { map, indexedValue ->
        map.remove(indexedValue.value)
        map[indexedValue.value] = indexedValue.index
        map
    }.values.toList()

    val n = first.size
    var ans = 0L
    var j = 0
    for (idx in first) {
        while (j < n && last[j] < idx) j++
        ans += n - j
    }
    return ans
}

private class MyReader3(inputStream: InputStream) {
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

private val reader = MyReader3(System.`in`)
private fun next() = reader.next()
private fun nextInt() = next().toInt()
private fun nextLong() = next().toLong()
private fun nextDouble() = next().toDouble()
private fun nextStrings(n: Int) = Array(n) { next() }
private fun nextInts(n: Int) = IntArray(n) { nextInt() }
private fun nextLongs(n: Int) = LongArray(n) { nextLong() }
private fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }