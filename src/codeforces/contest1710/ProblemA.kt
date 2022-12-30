package codeforces.contest1710

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val m = nextInt()
        val k = nextInt()
        val arr = IntArray(k) { nextInt() }
        val ans = solve(n, m, arr).or(solve(m, n, arr))
        println(if (ans) "Yes" else "No")
    }
}

private fun solve(n: Int, m: Int, array: IntArray): Boolean {
    var checkH = 0L
    var hasThree = false
    for (a in array) {
        if (n * 2 <= a) checkH += a / n
        if (n * 3 <= a) hasThree = true
    }
    return checkH >= m && (m % 2 == 0 || hasThree)
}


class MyReader(inputStream: InputStream) {
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

val reader = MyReader(System.`in`)
fun next() = reader.next()
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextStrings(n: Int) = Array(n) { next() }
fun nextInts(n: Int) = IntArray(n) { nextInt() }
fun nextLongs(n: Int) = LongArray(n) { nextLong() }
fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }