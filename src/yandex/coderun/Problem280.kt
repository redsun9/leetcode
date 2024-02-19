package yandex.coderun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.parseUnsignedInt
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
        val s = reader.readLine()
        val cPos = s.indexOf(' ')
        val a = parseUnsignedInt(s, 0, cPos, 10)
        val b = parseUnsignedInt(s, cPos + 1, s.length, 10)
        arr[i][0] = max(a, b)
        arr[i][1] = min(a, b)
    }
    writer.write(solve(arr).toString())
    reader.close()
    writer.close()
}

fun solve(arr: Array<IntArray>): Int {
    val n = arr.size
    Arrays.sort(arr) { a, b -> a[0] - b[0] }
    var ans = 0
    var maxHeight = 0
    var j = n - 1
    for (i in n - 1 downTo 0) {
        if (arr[i][1] < maxHeight) continue
        while (arr[i][0] < arr[j][0]) maxHeight = max(maxHeight, arr[j--][1])
        if (arr[i][1] >= maxHeight) ans++
    }
    return ans
}