package codeforces.contest1571

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

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

fun main() = repeat(nextInt()) {
    println(solve(next()))
}


fun solve(s: String) =
        if (s.all { it == '=' }) "="
        else if (s.none { it == '>' }) "<"
        else if (s.none { it == '<' }) ">"
        else "?"
