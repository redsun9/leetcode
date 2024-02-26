@file:Suppress("DuplicatedCode")

package codeforces.contest873

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

private const val p = 1_000_000_007L;

fun main(args: Array<String>) {
    val t = nextInt()
    for (i in 0 until t) {
        val n = nextInt()
        println(solve(nextInts(n), nextInts(n)))
    }

}

fun solve(a: IntArray, b: IntArray): Long {
//    a.shuffle()
//    b.shuffle()
    a.sort()
    b.sort()
    val n = a.size

    var ans = 1L
    var j = 0
    for (i in 0 until n) {
        while (j < n && a[i] > b[j]) j++
        if (i >= j) return 0L
        ans = ans * (j - i) % p
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