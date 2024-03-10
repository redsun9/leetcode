package codeforces.contest1914

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val p = IntArray(n) { if (it == 0) -1 else nextInt() - 1 }
        println(solve(p))
    }
}

fun solve(p: IntArray): Int {
    val n = p.size
    val adj = Array<MutableList<Int>>(n) { ArrayList() } // total, left
    for (i in 1 until n) adj[p[i]].add(i)
    val dp = Array<Pair<Int, Int>?>(n) { null }
    val stack = Stack<Int>()
    stack.push(0)
    while (!stack.isEmpty()) {
        val u = stack.peek()
        if (adj[u].isEmpty()) {
            dp[u] = 1 to 1
            stack.pop()
            continue
        }
        if (adj[u].any { dp[it] == null }) {
            stack.addAll(adj[u])
            continue
        }
        stack.pop()
        val maxLeft = adj[u].maxBy { dp[it]!!.second }
        val sumAll = adj[u].sumOf { dp[it]!!.first }
        if (sumAll - dp[maxLeft]!!.first >= dp[maxLeft]!!.second) {
            dp[u] = 1 + sumAll to 1 + sumAll % 2
        } else {
            dp[u] = 1 + sumAll to 1 + dp[maxLeft]!!.second - (sumAll - dp[maxLeft]!!.first)
        }
    }
    return (n - dp[0]!!.second) / 2
}


private class MyReader3(inputStream: InputStream) {
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

private val reader = MyReader3(System.`in`)
private fun next() = reader.next()
private fun nextInt() = next().toInt()
private fun nextLong() = next().toLong()
private fun nextDouble() = next().toDouble()
private fun nextStrings(n: Int) = Array(n) { next() }
private fun nextInts(n: Int) = IntArray(n) { nextInt() }
private fun nextLongs(n: Int) = LongArray(n) { nextLong() }
private fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }