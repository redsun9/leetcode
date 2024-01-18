package codeforces.contest1914

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val a = nextInts(n)
        val b = nextInts(n)
        val c = nextInts(n)
        println(solve(a, b, c))
    }
}

fun solve(a: IntArray, b: IntArray, c: IntArray): Int {
    val ai = getMax3WithIndex(a)
    val bi = getMax3WithIndex(b)
    val ci = getMax3WithIndex(c)
    var ans = 0
    for (i in ai) {
        for (j in bi) {
            for (k in ci) {
                if (i != j && j != k && i != k) ans = max(ans, a[i] + b[j] + c[k])
            }
        }
    }
    return ans
}

private fun getMax3WithIndex(array: IntArray): IntArray {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    var max3 = Int.MIN_VALUE
    var i1 = 0
    var i2 = 0
    var i3 = 0
    array.forEachIndexed { idx, num ->
        if (num > max1) {
            max3 = max2
            max2 = max1
            max1 = num
            i3 = i2
            i2 = i1
            i1 = idx
        } else if (num > max2) {
            max3 = max2
            max2 = num
            i3 = i2
            i2 = idx
        } else if (num > max3) {
            max3 = num
            i3 = idx
        }
    }
    return intArrayOf(i1, i2, i3)
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