@file:Suppress("DuplicatedCode")

package codeforces.contest1862

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val w = nextInt()
        val f = nextInt()
        val n = nextInt()
        val s = nextInts(n)
        println(solve(f, w, s))
    }
}

fun solve(w: Int, f: Int, s: IntArray): Int {
    val total = s.sum()
    val bitset = BitSet(total + 1)
    bitset.set(0)
    var curSum = 0
    for (num in s) {
        var tmp = curSum
        while (tmp >= 0) {
            bitset.set(tmp + num)
            tmp = bitset.previousSetBit(tmp - 1)
        }
        curSum += num
    }
    var ans = total
    var tmp = 0
    while (tmp != -1) {
        ans = min(ans, max((tmp + f - 1) / f, (total - tmp + w - 1) / w))
        tmp = bitset.nextSetBit(tmp + 1)
    }
    return ans
}

private class MyReader1(inputStream: InputStream) {
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

private val reader = MyReader1(System.`in`)
private fun next() = reader.next()
private fun nextInt() = next().toInt()
private fun nextLong() = next().toLong()
private fun nextDouble() = next().toDouble()
private fun nextStrings(n: Int) = Array(n) { next() }
private fun nextInts(n: Int) = IntArray(n) { nextInt() }
private fun nextLongs(n: Int) = LongArray(n) { nextLong() }
private fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }