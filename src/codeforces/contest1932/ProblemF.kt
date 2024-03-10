@file:Suppress("DuplicatedCode")

package codeforces.contest1932

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (i in 0 until tests) {
        val n = nextInt()
        val m = nextInt()
        val arr = Array(m) { nextInt() to nextInt() }
        println(solve(arr, n))
    }
}

fun solve(arr: Array<Pair<Int, Int>>, n: Int): Int {
    val numberOfCatsInLevel = IntArray(n + 2)
    val coming = Array<ArrayList<Pair<Int, Int>>>(n + 1) { ArrayList() }
    for (pair in arr) {
        numberOfCatsInLevel[pair.first]++
        numberOfCatsInLevel[pair.second + 1]--
        coming[pair.first].add(pair)
    }
    for (i in 2 until n + 1) numberOfCatsInLevel[i] += numberOfCatsInLevel[i - 1]

    val q = ArrayDeque<Pair<Int, Int>>()
    val dp = IntArray(n + 1)

    var ans = 0
    for (i in 1 until n + 1) {
        while (!q.isEmpty() && q.peekFirst().second < i) q.pollFirst()
        val lastLeaving = coming[i].maxByOrNull { it.second }
        if (lastLeaving != null && (q.isEmpty() || q.peekLast().second < lastLeaving.second)) q.addLast(lastLeaving)
        val prevIdx = if (q.isEmpty()) i - 1 else q.peekFirst().first - 1
        ans = maxOf(ans, dp[prevIdx] + numberOfCatsInLevel[i])
        dp[i] = ans
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