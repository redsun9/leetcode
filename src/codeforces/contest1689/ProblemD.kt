package codeforces.contest1689

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs


fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val m = nextInt()
        val n = nextInt()
        val strings = nextStrings(m)
        val ans = solve(strings)
        println("${ans.first + 1} ${ans.second + 1}")
    }
}


private fun solve(arr: Array<String>): Pair<Int, Int> {
    val m = arr.size
    val n = arr[0].length
    var ul = Pair(m + 1, n + 1)
    var ur = Pair(m + 1, -1)
    var dl = Pair(-1, n + 1)
    var dr = Pair(-1, -1)
    for (i in 0 until m)
        for (j in 0 until n)
            if (arr[i][j] == 'B') {
                if (ul.first + ul.second > i + j) ul = Pair(i, j)
                if (ur.first - ur.second > i - j) ur = Pair(i, j)
                if (-dl.first + dl.second > -i + j) dl = Pair(i, j)
                if (-dr.first - dr.second > -i - j) dr = Pair(i, j)
            }

    val points = listOf(ul, ur, dl, dr)
    return IntRange(0, m - 1).flatMap { i -> IntRange(0, n - 1).map { j -> Pair(i, j) } }
        .minBy { p -> points.maxOf { dist(it, p) } }
}

fun dist(a: Pair<Int, Int>, b: Pair<Int, Int>): Int = abs(a.first - b.first) + abs(a.second - b.second)

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