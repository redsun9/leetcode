@file:Suppress("DuplicatedCode")

package codeforces.contest1927

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) println(solve(nextInts(nextInt())))
}

fun solve(arr: IntArray): String {
    val n = arr.size
    val cnt = IntArray(26)
    val ans = CharArray(n)
    for (i in 0 until n) {
        for (c in 0 until 26) {
            if (cnt[c] == arr[i]) {
                ans[i] = 'a' + c
                cnt[c]++
                break
            }
        }
    }
    return String(ans)
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