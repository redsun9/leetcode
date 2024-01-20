@file:Suppress("DuplicatedCode")

//package codeforces.contest1881

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val tests = nextInt()
    for (t in 0 until tests) {
        val n = nextInt()
        val k = nextInt()
        val marked = nextInts(k)
        val edges = Array(n - 1) { nextInt() to nextInt() }
        println(solve(edges, marked))
    }
}

fun solve(edges: Array<Pair<Int, Int>>, marked: IntArray): Int {
    val n = edges.size + 1
    val adj = Array<MutableList<Int>>(n) { ArrayList() }
    for (edge in edges) {
        adj[edge.first - 1].add(edge.second - 1)
        adj[edge.second - 1].add(edge.first - 1)
    }
    val twoMaxesFromChild: Array<Pair<Int?, Int?>?> = arrayOfNulls(n)
    for (mark in marked) twoMaxesFromChild[mark - 1] = 0 to null

    dfs1(0, -1, adj, twoMaxesFromChild)
    val dp = IntArray(n)
    dfs2(0, -1, null, adj, twoMaxesFromChild, dp)
    return dp.min()
}

private fun dfs1(u: Int, parent: Int, adj: Array<MutableList<Int>>, dp1: Array<Pair<Int?, Int?>?>): Int? {
    var max1: Int? = dp1[u]?.first
    var max2: Int? = null
    for (v in adj[u]) {
        if (v == parent) continue
        val tmp = (dfs1(v, u, adj, dp1) ?: continue) + 1
        if (max1 == null) max1 = tmp
        else if (max1 < tmp) {
            max2 = max1
            max1 = tmp
        } else if (max2 == null || max2 < tmp) {
            max2 = tmp
        }
    }
    dp1[u] = max1 to max2
    return max1
}

private fun dfs2(
    u: Int,
    parent: Int,
    d: Int?,
    adj: Array<MutableList<Int>>,
    dp1: Array<Pair<Int?, Int?>?>,
    dp2: IntArray
) {
    dp2[u] = myMax(d, dp1[u]?.first)!!

    val val1 = dp1[u]?.first
    val val2 = dp1[u]?.second

    for (v in adj[u]) {
        if (v == parent) continue
        if (dp1[v]!!.first?.plus(1) != val1) dfs2(v, u, myMax(d, val1)?.plus(1), adj, dp1, dp2)
        else dfs2(v, u, myMax(d, val2)?.plus(1), adj, dp1, dp2)
    }
}

private fun myMax(a: Int?, b: Int?) = if (a == null) b else if (b == null) a else max(a, b)

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