@file:Suppress("DuplicatedCode")

package codeforces.contest550

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val s = next()
    val ans = solve(s)
    if (ans != null) {
        println("YES")
        println(ans)
    } else println("NO")
}

fun solve(s: String): Int? {
    var prev = arrayOfNulls<Int>(8)
    prev[0] = 0
    for (c in s) {
        val next = prev.copyOf()
        val d = c - '0'
        if (d % 8 == 0) return d
        for (i in 0 until 8) {
            if (prev[i] != null) {
                val newVal = prev[i]!! * 10 + d
                val j = newVal % 8
                if (j == 0) return newVal
                if (next[j] == null) next[j] = newVal
            }
        }
        prev = next
    }
    return null
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