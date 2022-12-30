package codeforces.contest1705

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val copyOperations = nextInt()
        val numberOfQueries = nextInt()
        val s = next()
        val operations = Array(copyOperations) { Pair(nextLong(), nextLong()) }
        val queries = LongArray(numberOfQueries) { nextLong() }
        val ans = solve(s, operations, queries)
        for (c in ans) println(c)
    }
}

private fun solve(s: String, operations: Array<Pair<Long, Long>>, queries: LongArray): CharArray {
    val c = operations.size
    val q = queries.size
    val lengths = LongArray(c + 1)
    lengths[0] = s.length.toLong()
    for (i in 0 until c) lengths[i + 1] = lengths[i] + operations[i].second - operations[i].first + 1
    val ans = CharArray(q)
    for (i in 0 until q) {
        var m = queries[i]
        for (j in c - 1 downTo 0) {
            if (lengths[j] < m) m = operations[j].first + m - lengths[j] - 1
        }
        ans[i] = s[(m - 1).toInt()]
    }
    return ans
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