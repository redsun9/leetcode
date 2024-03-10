@file:Suppress("DuplicatedCode")

//package codeforces.contest1932

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (i in 0 until tests) {
        val n = nextInt()
        val m = nextInt()
        val a = nextInts(n)
        val s = next()
        val ans = solve(a, m, s)
        println(ans.joinToString(separator = " ") { it.toString() })
    }
}

fun solve(arr: IntArray, k: Int, s: String): IntArray {
    val n = arr.size
    val m = s.length
    var left = s.count { it == 'L' }
    var right = n - 1 - s.count { it == 'R' }
    var curr = IntRange(left, right).fold(1L) { tmp, idx -> tmp * arr[idx] % k }
    val ans = IntArray(m)
    for (i in m - 1 downTo 0) {
        curr = if (s[i] == 'L') curr * arr[--left] % k else curr * arr[++right] % k
        ans[i] = curr.toInt()
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