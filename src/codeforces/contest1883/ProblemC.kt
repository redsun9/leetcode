package codeforces.contest1883

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val k = nextInt()
        val arr = nextInts(n)
        println(solve(arr, k))
    }
}

fun solve(arr: IntArray, k: Int): Int = if (k in setOf(2, 3, 5)) solve235(arr, k) else solve4(arr)

private fun solve235(arr: IntArray, k: Int): Int = arr.minOf { (k - it % k) % k }

private fun solve4(arr: IntArray): Int {
    if (arr.size == 1) return (4 - arr[0] % 4) % 4
    if (arr.any { it % 4 == 0 } || arr.count { it % 2 == 0 } >= 2) return 0
    if (arr.any { it % 2 == 0 } || arr.any { it % 4 == 3 }) return 1
    else return 2
}

internal class MyReader2(inputStream: InputStream) {
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