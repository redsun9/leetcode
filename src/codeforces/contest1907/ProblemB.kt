@file:Suppress("DuplicatedCode")

package codeforces.contest1907

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val s = next()
        println(solve(s))
    }
}

fun solve(s: String): String {
    val s1 = ArrayDeque<IndexedValue<Char>>()
    val s2 = ArrayDeque<IndexedValue<Char>>()
    for (indexedValue in s.withIndex()) {
        if (indexedValue.value == 'b') s1.removeLastOrNull()
        else if (indexedValue.value == 'B') s2.removeLastOrNull()
        else if (indexedValue.value.isLowerCase()) s1.addLast(indexedValue)
        else s2.addLast(indexedValue)
    }

    val ansLength = s1.size + s2.size
    val chars = CharArray(ansLength)
    for (i in 0 until ansLength) {
        if (!s1.isEmpty() && (s2.isEmpty() || s1.first().index < s2.first().index)) chars[i] = s1.removeFirst().value
        else chars[i] = s2.removeFirst().value
    }
    return String(chars)
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