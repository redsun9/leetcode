package codeforces.contest1914

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val k = nextInt()
        val a = nextInts(n)
        val b = nextInts(n)
        println(solve(a, b, k))
    }
}

fun solve(a: IntArray, b: IntArray, k: Int): Long {
    if (k == 0) return 0L
    if (k == 1) return a[0].toLong()
    var ans = 0L
    var maxB = 0
    var sumA = 0L
    val n = a.size
    for (i in 0 until n) {
        if (i >= k) break
        sumA += a[i]
        maxB = maxOf(maxB, b[i])
        ans = maxOf(ans, sumA + maxB * (k - i - 1L))
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