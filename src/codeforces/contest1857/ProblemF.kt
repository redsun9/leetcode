@file:Suppress("DuplicatedCode")

package codeforces.contest1857

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.roundToLong
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val arr = nextInts(n)
        val q = nextInt()
        val queries = Array(q) { nextInt() to nextLong() }
        val ans = solve(arr, queries)
        ans.forEach { println(it) }
    }
}

fun solve(arr: IntArray, queries: Array<Pair<Int, Long>>): LongArray {
    val count = HashMap<Int, Int>()
    for (num in arr) count[num] = count.getOrDefault(num, 0) + 1
    return LongArray(queries.size) {
        val roots = solveQuadratic(queries[it].first, queries[it].second)
        if (roots.isEmpty()) 0L
        else if (roots.size == 1) count[roots[0]]?.let { x -> x * (x - 1L) / 2 } ?: 0L
        else (count[roots[0]] ?: 0).toLong() * (count[roots[1]] ?: 0)
    }
}


// {x + y = a, x y = b}
// x = 1/2 (a +/- sqrt(a^2 - 4 b))
@Suppress("KotlinConstantConditions")
private fun solveQuadratic(sum: Int, product: Long): IntArray {
    val d2 = sum.toLong().times(sum) - 4 * product
    if (d2 < 0) return intArrayOf()
    if (d2 == 0L && sum % 2 != 0) return intArrayOf()
    if (d2 == 0L && sum % 2 == 0) return intArrayOf(sum / 2)
    val sqrt = intSqrt(d2)
    if (sqrt == null || (sum + sqrt) % 2 != 0L) return intArrayOf()
    val x1 = (sum + sqrt) / 2
    val x2 = (sum - sqrt) / 2
    if (x1 > Int.MAX_VALUE || x2 < Int.MIN_VALUE) return intArrayOf()
    return intArrayOf(x1.toInt(), x2.toInt())
}

private fun intSqrt(a: Long): Long? {
    var sqrt = sqrt(a.toDouble()).roundToLong()
    if (sqrt * sqrt > a) sqrt--
    if (sqrt * sqrt < a) sqrt++
    return if (sqrt * sqrt == a) sqrt else null
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